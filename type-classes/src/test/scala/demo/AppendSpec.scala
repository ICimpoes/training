package demo

import org.scalatest.{Matchers, WordSpec}

class AppendSpec extends WordSpec with Matchers {

  import demo.CanAppend.Ops._

  val person3 = Person("John", 30, Gender.Male)
  val person4 = Person("Jane", 25, Gender.Female)

  "Append" should {
    "work correctly" in {
      person3 |+| person4 shouldBe Person("John and Jane", 55, Gender.???)
    }
    "work correctly 2" in {
      // This is how the implicit conversation works for `person3 |+| person4`
      val ops = toAllAppend(person3)(Person.personAppend)
      ops |+| person4 shouldBe Person("John and Jane", 55, Gender.???)
    }
    "work correctly for strings" in {
      import CanAppend.implicits._

      "123" |+| "456" shouldBe "123456"

    }
    "work correctly for int" in {
      import CanAppend.implicits._

      123 |+| 456 shouldBe 579

    }
  }

}
