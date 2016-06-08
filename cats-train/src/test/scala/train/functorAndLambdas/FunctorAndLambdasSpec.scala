package train.functorAndLambdas

import cats.Functor
import org.scalatest.{Matchers, WordSpec}

class FunctorAndLambdasSpec extends WordSpec with Matchers {

  "A Functor[(?, ?)]" should {
    "correctly map over tuple" in {
      /**[[train.functorAndLambdas.aFunctor]] */
      type LString[?] = (String, ?)
      Functor[LString].map("2"-> 2)(_ + 2) shouldBe "2" -> 4
      Functor[LString].map("2"-> "2")(_ + "2") shouldBe "2" -> "22"
      Functor[({type L[A] = (Int, A)})#L].map(2-> 2)(_ + 2) shouldBe 2 -> 4
      Functor[({type L[A] = (Long, A)})#L].map(2L-> "2")(_ + "2") shouldBe 2L -> "22"
    }
  }
}
