package training.catsCore.functor

import cats.Functor
import cats.data.Xor
import org.scalatest.{Matchers, WordSpec}

class FunctorSpec extends WordSpec with Matchers {

  "Functor[Wrapper]" should {
    "correctly map a Value" in {
      Functor[Wrapper].map(Value(15))(_ + 5) shouldBe Value(20)
    }
    "correctly map a NoValue" in {
      val a: Wrapper[Int] = NoValue
      Functor[Wrapper].map(a)(_ + 5) shouldBe NoValue
    }
    "correctly compose a Wrapper with List" in {
      import cats.std.list.listInstance
      Functor[Wrapper].compose[List].map(Value(List(1, 2, 3, 4, 5)))(_ + 5) shouldBe Value(List(6, 7, 8, 9, 10))
    }
    "correctly lift a Value" in {
      Functor[Wrapper].lift{ (_: Int) + 5 } (Value(5)) shouldBe Value(10)
    }
    "correctly void a Value" in {
      Functor[Wrapper].void(Value(5)) shouldBe Value()
    }
    "correctly void a NoValue" in {
      Functor[Wrapper].void(NoValue) shouldBe NoValue
    }
    "correctly fproduct a Value" in {
      Functor[Wrapper].fproduct(Value(5))(_.toString) shouldBe Value(5 -> "5")
    }
    "correctly fproduct a NoValue" in {
      Functor[Wrapper].fproduct(NoValue)(_.toString) shouldBe NoValue
    }
    "correctly as a Value" in {
      Functor[Wrapper].as(Value(5), "5") shouldBe Value("5")
    }
    "correctly as a NoValue" in {
      Functor[Wrapper].as(NoValue, "5") shouldBe NoValue
    }
    "correctly interpret the Identity Law" in {
      Functor[Wrapper].map(Value(5))(identity) shouldBe Value(5)
    }
    "correctly interpret the Composition Law" in {
      val x = Xor.Right(5)
      val f = (_: Int) + 1
      val g = (_: Int) * 5
      x.map(f).map(g) shouldBe x.map(f andThen g)
    }
  }

}
