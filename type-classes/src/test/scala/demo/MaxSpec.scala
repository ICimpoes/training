package demo

import java.util.Comparator

import org.scalatest.{Matchers, WordSpec}

class MaxSpec extends WordSpec with Matchers {

  val person1 = Person_old("John", 30, Gender.Male)
  val person2 = Person_old("JANE", 25, Gender.Female)

  val person3 = Person("John", 30, Gender.Male)
  val person4 = Person("JANE", 25, Gender.Female)

  "Max_old" should {
    "return correct value" in {
      max_old(person1, person2) shouldBe person1

    }
  }
  "Max" should {
    "return correct value" in {
      max(person3, person4) shouldBe person3

    }
    "return correct value for custor ord" in {
      implicit val customOrd = new Comparator[Person] {
        override def compare(t: Person, t1: Person): Int = {
          t1.age.compareTo(t.age)
        }
      }
      max(person3, person4) shouldBe person4

    }
  }

}
