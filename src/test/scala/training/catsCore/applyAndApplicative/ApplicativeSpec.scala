package training.catsCore.applyAndApplicative

import cats.Applicative
import org.scalatest.{Matchers, WordSpec}
import training.catsCore.functor.{NoValue, Value, Wrapper}

class ApplicativeSpec extends WordSpec with Matchers {

  "An Applicative" when {
    val F = Applicative[Wrapper]
    "calling pure" should {
      "return a Value[A]" in {
        F.pure(10) shouldBe Value(10)
        F.pure("") shouldBe Value("")
      }
    }
    "calling map on a Value" should {
      "return mapped Value" in {
        val v = Value(56)
        F.map(v)(_ + 95 / 5) shouldBe Value(56 + 95 / 5)
        F.map(v)(_ + 95 / 5) shouldBe Value(56 + 95 / 5)
      }
    }
    "calling map on the NoValue" should {
      "return NoValue" in {
        val n = NoValue
        F.map(n)(_.toString) shouldBe NoValue
      }
    }
    "calling sequenceA on List[Int => Int]" should {
      "return Int => List[Int]" in {
        import cats.std.function._
        type F[A] = (Int) => A
        val f: F[List[Int]] = sequenceA[F, Int](List(_ + 3, _ + 2, _ + 1))
        f(3) shouldBe List(3 + 3, 3 + 2, 3 + 1)
      }
    }
  }

}
