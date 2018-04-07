import java.io._
import java.nio.file.Files

import controllers.AccountNumberGenerator
import org.scalatest.mock.MockitoSugar
import org.scalatest.matchers._
import org.mockito.Mockito._
import org.mockito.Matchers.any
import org.scalatest.{ShouldMatchers, WordSpec}
import service.AccountFileReader

class AccountNumberGeneratorSpec extends WordSpec with ShouldMatchers with MockitoSugar{

  "readAccountNumber" should {

    "return the digit 0 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _ ", "| |", "|_|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "0"
    }


    "return the digit 1 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("   ", "  |", "  |"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "1"

    }

    "return the digit 000000000 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "| || || || || || || || || |", "|_||_||_||_||_||_||_||_||_|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "000000000"
    }

    "return the digit 111111111 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("                           ", "  |  |  |  |  |  |  |  |  |", "  |  |  |  |  |  |  |  |  |"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "111111111"

    }

    "return the digit 222222222 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", " _| _| _| _| _| _| _| _| _|", "|_ |_ |_ |_ |_ |_ |_ |_ |_ "))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "222222222"

    }

    "return the digit 333333333 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", " _| _| _| _| _| _| _| _| _|", " _| _| _| _| _| _| _| _| _|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "333333333"

    }

    "return the digit 444444444 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("                           ", "|_||_||_||_||_||_||_||_||_|", "  |  |  |  |  |  |  |  |  |"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "444444444"

    }

    "return the digit 555555555 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", " _| _| _| _| _| _| _| _| _|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "555555555"

    }

    "return the digit 666666666 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", "|_||_||_||_||_||_||_||_||_|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "666666666"

    }

    "return the digit 777777777 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "  |  |  |  |  |  |  |  |  |", "  |  |  |  |  |  |  |  |  |"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "777777777"

    }

    "return the digit 888888888 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_||_||_||_||_||_||_||_||_|", "|_||_||_||_||_||_||_||_||_|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "888888888"

    }

    "return the digit 999999999 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_||_||_||_||_||_||_||_||_|", " _| _| _| _| _| _| _| _| _|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "999999999"

    }

    "return the digit 123456789 from 1st 3 letters" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "123456789"

    }

    "return number and ERR if not valid account number" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "| || || || || || || ||_   |", "|_||_||_||_||_||_||_| _|  |"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "000000057"
      generator.reformatNumber(result) shouldBe "000000057 ERR"

    }

    "return number and ILL if not valid account number" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn( List("    _  _     _  _  _  _  _", "  | _| _||_| _ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "1234?678?"
      generator.reformatNumber(result) shouldBe "1234?678? ILL"

    }

    "return ? from 1st 3 letters if not matching the pattern" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _ ", "_ |", "|_|"))
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.readAccountNumber("file")
      result shouldBe "?"

    }

    "return the exception if file path is not correct" in {
      val file = "../resources/000000000.txt"
      val generator = new AccountNumberGenerator(new AccountFileReader)
      intercept[FileNotFoundException] {
        generator.readAccountNumber(file)
      }
    }
  }

  "reformatNumber" should {

    "return correct number if valid" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      generator.reformatNumber("000000051") shouldBe "000000051"
    }

    "return number with ERR if not valid" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      generator.reformatNumber("000000057") shouldBe "000000057 ERR"
    }

    "return number with ILL if not correct" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      generator.reformatNumber("1234?678?") shouldBe "1234?678? ILL"
    }


  }

  "validateNumber" should{

    "return true for valid account number" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      generator.validateNumber("000000051") shouldBe true
    }

    "return false for invalid account number" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      generator.validateNumber("664371495") shouldBe false
    }
  }

  "replaceStrings" should{

    "return valid combinations for given string" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      generator.replaceStrings(" _ ") shouldBe List("__ ", "|_ ", "   ", " | ", " __", " _|")
    }
  }

  "getCorrectAccountNumber" should{

    "return true for valid account number" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("    _  _     _  _  _  _  _ ", "  | _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(123456789)"
    }

    "return number and ERR if not valid account number 888888888" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_||_||_||_||_||_||_||_||_|", "|_||_||_||_||_||_||_||_||_|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(888888888 AMB ['888886888', '888888880', '888888988'])"
    }

    "return number and ERR if not valid account number 555555555" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", " _| _| _| _| _| _| _| _| _|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(555555555 AMB ['555655555', '559555555'])"
    }

    "return number and ERR if not valid account number 666666666" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", "|_||_||_||_||_||_||_||_||_|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(666666666 AMB ['666566666', '686666666'])"
    }

    "return number and ERR if not valid account number 999999999" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _  _  _  _  _  _  _  _  _ ", "|_||_||_||_||_||_||_||_||_|", " _| _| _| _| _| _| _| _| _|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(999999999 AMB ['899999999', '993999999', '999959999'])"
    }

    "return number and ERR if not valid account number 490067715" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("    _  _  _  _  _  _     _ ", "|_||_|| || ||_   |  |  ||_ ", "  | _||_||_||_|  |  |  | _|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(490067715 AMB ['490067115', '490067719', '490867715'])"
    }

    "return number and ERR if not valid account number 000000051" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List(" _     _  _  _  _  _  _    ", "| || || || || || || ||_   |", "|_||_||_||_||_||_||_| _|  |"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(000000051)"
    }

    "return number and ERR if not valid account number 123456789" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("    _  _     _  _  _  _  _ ", " _| _| _||_||_ |_   ||_||_|", "  ||_  _|  | _||_|  ||_| _|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(123456789)"
    }

    "return number and ERR if not valid account number 490867715" in {
      val mockAccountFileReader = mock[AccountFileReader]
      when(mockAccountFileReader.fileReader(any())).thenReturn(List("    _  _  _  _  _  _     _ ", "|_||_|| ||_||_   |  |  | _ ", "  | _||_||_||_|  |  |  | _|"))
      doNothing().when(mockAccountFileReader).fileWritter(any(),any())
      val generator = new AccountNumberGenerator(mockAccountFileReader)
      val result = generator.getCorrectAccountNumber("file","outFile")
      result shouldBe "List(490867715)"
    }

    "finally return the correct outputfile" in {
      val generator = new AccountNumberGenerator(new AccountFileReader)
      val result = generator.getCorrectAccountNumber("resources/use_case_4_in.txt","resources/op_use_case_4.txt")
      result shouldBe "List(711111111, 777777177, 200800000, 333393333, 888888888 AMB ['888886888', '888888880', '888888988'], 555555555 AMB ['555655555', '559555555'], 666666666 AMB ['666566666', '686666666'], 999999999 AMB ['899999999', '993999999', '999959999'], 490067715 AMB ['490067115', '490067719', '490867715'], 123456789, 000000051, 490867715)"

    }

  }
}