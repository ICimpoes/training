package first

import org.scalatest.{Matchers, WordSpec}
import fixture._

class FirstPuzzleSpec extends WordSpec with Matchers {

  "First Solution" should {
    "be correct" in {
      Solutions.one(firstInput) shouldBe firstOutput
    }
  }

}
