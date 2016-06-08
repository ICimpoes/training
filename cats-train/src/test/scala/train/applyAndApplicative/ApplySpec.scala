package train.applyAndApplicative

import cats._
import cats.syntax.apply._
import org.scalatest.{Matchers, WordSpec}
import train.functor.{wrapperFunctor => _, _}

class ApplySpec extends WordSpec with Matchers {

  "Apply[?]" should {
    val F = Apply[Wrapper]
    "correctly apply List" in {
      import cats.std.list.listInstance
      val fs = List(1, 2, 3) map { x => x * 3 + (_: Int) } // == {(_: Int) * 3 + (_: Int)}.curried
      val vs = List(5, 10)
      vs.ap(fs) shouldBe List(8, 13, 11, 16, 14, 19)
    }
    "correctly apply Value" in {
      val f = Value { x: Int => (x * 2 + 2).toString }
      val v = Value(6)
      F.ap(v)(f) shouldBe Value((6 * 2 + 2).toString)
    }
    "correctly apply Value" when {
      "using Functor to construct Wrapper[A => B]" in {
        //f(x) = (x + 3) * 5
        val f = Functor[Wrapper].map(Value[Int](5)) { x => ((_: Int) + 3) andThen (_ * x) }
        val v = Value(6)
        F.ap(v)(f) shouldBe Value((6 + 3) * 5)
        F.ap(NoValue)(f) shouldBe NoValue
        F.ap(Value(0))(f) shouldBe Value(3 * 5)
      }
    }
    "correctly apply NoValue as a F[A => B]" in {
      val f: Wrapper[Int => Nothing] = NoValue
      val v = Value(6)
      F.ap(v)(f) shouldBe NoValue
    }
    "correctly apply NoValue as a F[A]" in {
      val f = Value((_: Int) * 2 + 2)
      val v = NoValue
      F.ap(v)(f) shouldBe NoValue
    }
  }
}
