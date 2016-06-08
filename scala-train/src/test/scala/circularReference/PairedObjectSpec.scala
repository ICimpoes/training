package circularReference

import org.scalatest.{Matchers, WordSpec}
import train.circularReference.PairedObject

class PairedObjectSpec extends WordSpec with Matchers {

  "PairedObject" should {
    "correctly initialise" in {
      lazy val p1: PairedObject = new PairedObject(p2, "p1")
      lazy val p2: PairedObject = new PairedObject(p1, "p2")

      p1.partner shouldBe p2
      p2.partner shouldBe p1
    }
  }

}
