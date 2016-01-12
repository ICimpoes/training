package training.scalaCore.enums

object Currency extends Enumeration {
  type Currency = Value
  val GBP = Value("GBP")
  val EUR = Value("EUR")
}