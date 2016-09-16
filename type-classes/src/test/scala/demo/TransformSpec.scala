package demo

import org.scalatest.{Matchers, WordSpec}

class TransformSpec extends WordSpec with Matchers {

  import CanTransform.Ops._

  "Transform" should {
    "work correctly for strings to boolean" in {
      import CanTransform.implicits.stringToBoolean
      val x: Boolean = "123".|->[Boolean]

      man.|->[Dog].|->[Woman].|->[Cat].|->[Man]

      x shouldBe true
      "".|->[Boolean] shouldBe false
    }
    "work correctly for strings to int" in {
      import CanTransform.implicits.stringToInt
      "123".|-> shouldBe 3
    }
    "work correctly for ints" in {
      import CanTransform.implicits.intToBoolean
      123.|->[Boolean] shouldBe true
      0.|->[Boolean] shouldBe false
    }
  }

}
