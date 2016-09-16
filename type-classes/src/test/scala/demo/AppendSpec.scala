package demo

import demo.CanAppend.Ops
import org.scalatest.{Matchers, WordSpec}

class AppendSpec extends WordSpec with Matchers {

  import demo.CanAppend.Ops._

  val person3 = Person("John", 30, Gender.Male)
  val person4 = Person("Jane", 25, Gender.Female)

  "Append" should {
    "work correctly" in {
      person3 |+| person4 shouldBe Person("John and Jane", 55, Gender.???)
    }
//    "work correctly 2" in {
//      val ops: Ops[Person] {val typeClassInstance: CanAppend[Person]; val self: Person} = toAllAppend(person3)(Person.personAppend)
//      ops |+| person4 shouldBe Person("John and Jane", 55, Gender.???)
//    }
    "work correctly for strings" in {
      import CanAppend.implecits._

      "123" |+| "456" shouldBe "123456"

    }
    "work correctly for int" in {
      import CanAppend.implecits._

      123 |+| 456 shouldBe 579

    }
  }

}
