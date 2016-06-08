package train.seigroup

import algebra.Semigroup
import cats.std.all._
import cats.syntax.semigroup._
import org.scalatest.{Matchers, WordSpec}

class SemigroupSpec extends WordSpec with Matchers {

  /**
    * A Semigroup is any set `A` with an associative operation (`combine`).
    * It's a weaker version of Monoid. (Doesn't provide `empty` value)
    */
  "Semigroup" should {
    "correctly combine Lists" in {
      List(1, 2, 3) |+| List(2, 4, 5) |+| Nil shouldBe List(1, 2, 3, 2, 4, 5)
    }
    "correctly combine Strings" in {
      "one" |+| "two" shouldBe "onetwo"
    }
    "correctly combine Int" in {
      1 |+| 2 shouldBe 3
      Semigroup.multiplicative[Int].combine(3, 5) shouldBe 15
    }
  }

}
