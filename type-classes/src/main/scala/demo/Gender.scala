package demo

object Gender extends Enumeration {
  type Gender = Value
  val Male = Value("Male")
  val Female = Value("Female")
  val ??? = Value("???")
}
