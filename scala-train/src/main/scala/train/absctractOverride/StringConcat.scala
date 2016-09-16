package train.absctractOverride

trait StringConcat {
  def string(s: String): String
}

trait String1 extends StringConcat {
  abstract override def string(s: String) = {
    val prefix = "~String1~ -> "
    val suffix = " <- ~String1~"
    val result = super.string(s)
    prefix + result + suffix
  }
}

trait String2 extends StringConcat {
  abstract override def string(s: String) = {
    val prefix = "~String2~ -> "
    val suffix = " <- ~String2~"
    val result = super.string(s)
    prefix + result + suffix
  }
}

trait StringConcatImpl extends StringConcat {
  def pref: String
  def suff: String
  override def string(s: String): String = {
    pref + s + suff
  }
}
