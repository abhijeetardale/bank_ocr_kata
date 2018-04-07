import java.io._
import java.nio.file.Files

import akka.stream.scaladsl._
import akka.util.ByteString
import org.scalatest.{ShouldMatchers, WordSpec}
import org.scalatestplus.play._
import play.api.libs.ws.WSClient
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._
import service.AccountFileReader

class AccountFileReaderSpec extends WordSpec with ShouldMatchers {

  "fileReader" should {

    "return the correct file content for 0" in {
      val file = "resources/000000000.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "| || || || || || || || || |", "|_||_||_||_||_||_||_||_||_|")

    }

    "return the correct file content for 1" in {
      val file = "resources/111111111.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List("                           ", "  |  |  |  |  |  |  |  |  |", "  |  |  |  |  |  |  |  |  |")

    }

    "return the correct file content for 2" in {
      val file = "resources/222222222.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", " _| _| _| _| _| _| _| _| _|", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ")

    }

    "return the correct file content for 3" in {
      val file = "resources/333333333.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", " _| _| _| _| _| _| _| _| _|", " _| _| _| _| _| _| _| _| _|")

    }

    "return the correct file content for 4" in {
      val file = "resources/444444444.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List("                           ", "|_||_||_||_||_||_||_||_||_|", "  |  |  |  |  |  |  |  |  |")

    }

    "return the correct file content for 5" in {
      val file = "resources/555555555.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", " _| _| _| _| _| _| _| _| _|")

    }

    "return the correct file content for 6" in {
      val file = "resources/666666666.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", "|_||_||_||_||_||_||_||_||_|")

    }

    "return the correct file content for 7" in {
      val file = "resources/777777777.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "  |  |  |  |  |  |  |  |  |", "  |  |  |  |  |  |  |  |  |")

    }

    "return the correct file content for 8" in {
      val file = "resources/888888888.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "|_||_||_||_||_||_||_||_||_|", "|_||_||_||_||_||_||_||_||_|")

    }

    "return the correct file content for 9" in {
      val file = "resources/999999999.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "|_||_||_||_||_||_||_||_||_|", " _| _| _| _| _| _| _| _| _|")
    }

    "return the correct file content for 123456789" in {
      val file = "resources/123456789.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|")

    }

    "return the correct file content for 000000057" in {
      val file = "resources/000000057.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List(" _  _  _  _  _  _  _  _  _ ", "| || || || || || || ||_   |", "|_||_||_||_||_||_||_| _|  |")

    }

    "return the correct file content for 1234?678?" in {
      val file = "resources/1234?678?.txt"
      val reader = new AccountFileReader
      val result = reader.fileReader(file)
      result shouldBe List("    _  _     _  _  _  _  _", "  | _| _||_| _ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _")
    }

    "return the exception if file path is not correct" in {
      val file = "../resources/000000000.txt"
      val reader = new AccountFileReader
      intercept[FileNotFoundException] {
        reader.fileReader(file)
      }

    }
  }
}