package training.catsCore.applyAndApplicative

import cats.Applicative
import org.scalatest.{Matchers, WordSpec}
import training.catsCore.functor.{NoValue, Value, Wrapper}

class ApplicativeSpec extends WordSpec with Matchers {

  "An Applicative" when {
    "calling pure" should {
      "return a Value[A]" in {
        Applicative[Wrapper].pure(10) shouldBe Value(10)
        Applicative[Wrapper].pure("") shouldBe Value("")
      }
    }
    "calling map on a Value" should {
      "return mapped Value" in {
        val v = Value(56)
        Applicative[Wrapper].map(v)(_ + 95 / 5) shouldBe Value(56 + 95 / 5)
      }
    }
    "calling map on the NoValue" should {
      "return NoValue" in {
        val n = NoValue
        Applicative[Wrapper].map(n)(_.toString) shouldBe NoValue
      }
    }
    "calling sequenceA on List[Int => Int]" should {
      "return Int => List[Int]" in {
        import cats.std.list._
        import cats.std.function._
        type F[A] = (Int) => A
        val f: F[List[Int]] = sequenceA[F, Int](List((_: Int) + 3, (_: Int) + 2, (_: Int) + 1))
        f(3) shouldBe List(3 + 3, 3 + 2, 3 + 1)
      }
    }
  }

}
