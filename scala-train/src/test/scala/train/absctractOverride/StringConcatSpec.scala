package train.absctractOverride

import org.scalatest.{Matchers, WordSpec}

class StringConcatSpec extends WordSpec with Matchers {

  "Abstract override" should {
    val p: String = "~a~"
    val s: String = "~b~"
    "be correctly applied" in {
      new StringConcatImpl with String1 {
        val pref: String = p
        val suff: String = s
      }.string("just a string") shouldBe "~String1~ -> " + p + "just a string" + s + " <- ~String1~"
    }
    "be applied in correct order" in {
      new StringConcatImpl with String1 with String2 {
        val pref: String = p
        val suff: String = s
      }.string("just a string") shouldBe "~String2~ -> " + "~String1~ -> " + p + "just a string" + s + " <- ~String1~" + " <- ~String2~"

      new StringConcatImpl with String2 with String1 {
        val pref: String = p
        val suff: String = s
      }.string("just a string") shouldBe "~String1~ -> " + "~String2~ -> " + p + "just a string" + s + " <- ~String2~" + " <- ~String1~"
    }
  }
}
