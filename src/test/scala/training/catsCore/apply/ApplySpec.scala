package training.catsCore.apply

import cats.Apply
import org.scalatest.{Matchers, WordSpec}
import training.catsCore.functor.{wrapperFunctor => _, _}

class ApplySpec extends WordSpec with Matchers {

  "Apply[?]" should {
    "correctly ap for List" in {
      import cats.std.list.listInstance
      val fs = List(1, 2, 3) map {x => x * 3 + (_: Int) }// == {(_: Int) * 3 + (_: Int)}.curried
      val vs = List(5, 10)
      Apply[List].ap(vs)(fs) shouldBe List(8, 13, 11, 16, 14, 19)
    }
    "correctly ap for Value" in {
      import training.catsCore.apply.wrapperApply
      val f = Value{x: Int => (x * 2 + 2).toString}
      val v = Value(6)
      Apply[Wrapper].ap(v)(f) shouldBe Value((6 * 2 + 2).toString)
    }
    "correctly ap for NoValue as a F[A => B]" in {
      import training.catsCore.apply.wrapperApply
      val f = NoValue
      val v = Value(6)
      Apply[Wrapper].ap(v)(f) shouldBe NoValue
    }
    "correctly ap for NoValue as a F[A]" in {
      import training.catsCore.apply.wrapperApply
      val f = Value{(_: Int) * 2 + 2}
      val v = NoValue
      Apply[Wrapper].ap(v)(f) shouldBe NoValue
    }
  }
}
