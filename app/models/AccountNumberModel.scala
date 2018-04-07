package models

/*
sealed abstract class NumberConstant(val pattern: String) extends Enumeration

case object SSS extends NumberConstant("   ")

case object SSP extends NumberConstant("  |")

case object PUP extends NumberConstant("|_|")

case object SUS extends NumberConstant(" _ ")

case object SUP extends NumberConstant(" _|")

case object PUS extends NumberConstant("|_ ")

case object PSP extends NumberConstant("| |")

*/


object NumberPattern extends Enumeration {
  type pattern = Value
  val One =   Value("   " + ","  + "  |" + ","  + "  |")
  val Two =   Value(" _ " + ","  + " _|" + ","  + "|_ ")
  val Three = Value(" _ " + ","  + " _|" + ","  + " _|")
  val Four =  Value("   " + ","  + "|_|" + ","  + "  |")
  val Five =  Value(" _ " + ","  + "|_ " + ","  + " _|")
  val Six =   Value(" _ " + ","  + "|_ " + ","  + "|_|")
  val Seven = Value(" _ " + ","  + "  |" + ","  + "  |")
  val Eight = Value(" _ " + ","  + "|_|" + ","  + "|_|")
  val Nine =  Value(" _ " + ","  + "|_|" + ","  + " _|")
  val Zero =  Value(" _ " + ","  + "| |" + ","  + "|_|")


  def getDigit(p:NumberPattern.Value): String = {
    p match {
      case NumberPattern.One => "1"
      case NumberPattern.Four => "4"
      case NumberPattern.Two => "2"
      case NumberPattern.Three => "3"
      case NumberPattern.Eight => "8"
      case NumberPattern.Nine => "9"
      case NumberPattern.Five => "5"
      case NumberPattern.Six => "6"
      case NumberPattern.Seven => "7"
      case NumberPattern.Zero => "0"
    }
  }
}


