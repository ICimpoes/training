package enums

import org.scalatest.{Matchers, WordSpec}
import train.enums.Currency

class CurrencySpec extends WordSpec with Matchers {

  "Currency" should {
    "correctly solve equality" in {
      Currency.EUR == Currency.GBP shouldEqual false
      Currency.GBP == Currency.EUR shouldEqual false
      Currency.EUR == Currency.EUR shouldEqual true
      Currency.GBP == Currency.GBP shouldEqual true
    }
  }

}
