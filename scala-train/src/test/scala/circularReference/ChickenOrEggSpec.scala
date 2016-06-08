package circularReference

import org.scalatest.{Matchers, WordSpec}
import train.circularReference.ChickenOrEgg._

class ChickenOrEggSpec extends WordSpec with Matchers {

  "Circular Reference" should {
    "resolve the Chicken/Egg problem" in {
      lazy val chicken: Chicken = new Chicken(egg)
      lazy val egg: Egg = new Egg(chicken)

      chicken.offspring shouldBe egg
      egg.mother shouldBe chicken
    }
  }

}