package train.transaction

import org.scalatest.{Matchers, WordSpec}
import train.transaction.Implicits._

import scala.util.{Failure, Success}

class TransactionSpec extends WordSpec with Matchers {

  "A Transaction" when {
    val a1 = Account(1, 100)
    val a2 = Account(2, 200)
    "transaction succeeded" should {
      "return Success" in {
        val expected = Success(a1.copy(sum = a1.sum - 10), a2.copy(sum = a2.sum + 10))
        a1.transact(10).to(a2) shouldBe expected
        a1 ~ 10 to a2 shouldBe expected
        a1 ~ 10 -> a2 shouldBe expected
        a1.transact(10) -> a2 shouldBe expected
      }
    }
    "not enough money on the Account" should {
      "return Failure(TransactionException)" in {
        val expected = Failure(TransactionException(s"Not enough money on acc ${a1.count}"))
        a1 ~ 101 -> a2 shouldBe expected
      }
    }
    "transaction sum is not greater than 0" should {
      "return Failure(TransactionException)" in {
        val expected = Failure(TransactionException(s"Sum must be greater than 0"))
        a1 ~ -1 -> a2 shouldBe expected
      }
    }
  }

}
