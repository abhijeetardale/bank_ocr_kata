package controllers

import com.google.inject.{Inject, Singleton}
import models._
import service.AccountFileReader

import scala.annotation.tailrec

@Singleton
class AccountNumberGenerator@Inject()(reader:AccountFileReader){

  def getCorrectAccountNumber(filePath:String,outFilePath:String): String ={

    val fileLines = reader.fileReader(filePath).grouped(4)

    val result = fileLines.map{ lines =>

      val num = getRecursiveNumber(lines(0),lines(1),lines(2))
      val numbers = getValidateNumbers(lines(0),lines(1),lines(2))

      num.contains("?") match {
        case false if(validateNumber(num)) => num
        case _ if(numbers.length == 1) => numbers(0)
        case _ if(numbers.length >1) => num + s" AMB ${numbers.map(_.toInt).sorted.mkString("['","', '","']") }"
        case true => num + " ILL"
        case _ => num + " ERR"
      }

    }.toList

    reader.fileWritter(outFilePath,result)

    result.toString()
  }

  def getValidateNumbers(line1:String, line2:String, line3:String): List[String] ={

    List(line1,line2,line3).foldLeft(List[String](),0) ((ind, line) =>

      (replaceStrings(line).foldLeft(List[String]()) { (acc, index) =>
        ind._2 match {
          case 0 => getMaybeNumber(getRecursiveNumber(index, line2, line3)).fold(acc)(acc ::: List(_))
          case 1 => getMaybeNumber(getRecursiveNumber(line1, index, line3)).fold(acc)(acc ::: List(_))
          case 2 => getMaybeNumber(getRecursiveNumber(line1, line2, index)).fold(acc)(acc ::: List(_))
        }
       } ++ ind._1, ind._2 + 1)

    )._1
  }

  def getMaybeNumber(num :String): Option[String] ={
    num.contains("?") match {
      case false if(validateNumber(num)) => Some(num)
      case _ => None
    }
  }

  def replaceStrings(num:String): List[String] = {
    (0 to num.length-1 flatMap  { index => num.charAt(index).toString match {
      case " " => List(num.substring(0,index) + "_" + num.substring(index + 1), num.substring(0,index) + "|" + num.substring(index + 1))
      case "_" => List(num.substring(0,index) + " " + num.substring(index + 1), num.substring(0,index) + "|" + num.substring(index + 1))
      case "|" => List(num.substring(0,index) + " " + num.substring(index + 1), num.substring(0,index) + "_" + num.substring(index + 1))
    }}).toList
  }

  def getRecursiveNumber(line1:String, line2:String, line3:String): String ={

    @tailrec
    def numberAccumulator(l1:String, l2:String, l3:String, number:String): String= {
      l1.splitAt(3)._1.isEmpty match {
        case true => number
        case false => val generatedDigit =  getNumber(l1.splitAt(3)._1, l2.splitAt(3)._1, l3.splitAt(3)._1)
          numberAccumulator(l1.splitAt(3)._2, l2.splitAt(3)._2, l3.splitAt(3)._2, number + generatedDigit)
      }
    }
    numberAccumulator(line1,line2,line3, "")
  }

  def validateNumber(number:String): Boolean ={

    number.reverse.foldLeft((0,0)){
      (x,i)=> (((x._1)+(i.toString.toInt*(x._2+1))),(x._2+1))
    }._1%11==0
  }

  def getNumber(line1:String, line2:String, line3:String): String = {

    NumberPattern.values.find(_.toString==line1 + ","  + line2 + ","  + line3).fold("?")(NumberPattern.getDigit(_))

  }


  def reformatNumber(num :String): String ={

    num.contains("?") match {
      case true => num + " ILL"
      case false if(validateNumber(num)) => num
      case _ => num + " ERR"
    }
  }

  def readAccountNumber(filePath:String): String ={

    val list = reader.fileReader(filePath)

    getRecursiveNumber(list(0),list(1),list(2))
  }

}