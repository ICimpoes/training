package demo

import org.scalatest.{Matchers, WordSpec}

class TransformSpec extends WordSpec with Matchers {

  import CanTransform.Ops._

  "Transform" should {
    "work correctly for strings to boolean" in {
      import CanTransform.implicits.stringToBoolean
      "123".|->[Boolean] shouldBe true
      "".|->[Boolean] shouldBe false
    }
    "work correctly for strings to int" in {
      import CanTransform.implicits.stringToInt
      "123".|-> shouldBe 3
      "".|-> shouldBe 0
    }
    "work correctly for ints" in {
      import CanTransform.implicits.intToBoolean
      123.|->[Boolean] shouldBe true
      0.|->[Boolean] shouldBe false
    }
    "work correctly for multiple transformations" in {
      import CanTransform.implicits.intToBoolean
      import CanTransform.implicits.stringToInt
      "123".|->[Int].|->[Boolean] shouldBe true
      "".|->[Int].|->[Boolean] shouldBe false
    }

    "work correctly for men" in {
      Man("John", 30).|->[Woman] shouldBe Woman("John", 30)
    }
    "work correctly for women" in {
      Woman("Jane", 25).|->[Man] shouldBe Man("Jane", 25)
    }
  }

}
