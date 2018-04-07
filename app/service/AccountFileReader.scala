package service

import java.io.{FileWriter, BufferedWriter, File, PrintWriter}

import com.google.inject.Singleton

import scala.io.Source

@Singleton
class AccountFileReader {

  def fileReader(filePath:String):List[String] ={
    val bufferedSource = Source.fromFile(filePath)
    val result = bufferedSource.getLines.toList
    bufferedSource.close
    result
  }

  def fileWritter(filePath:String, contents:List[String]): Unit ={
    val file = new File(filePath)
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(contents.mkString("\n"))
    bw.flush()
    bw.close()
  }
}