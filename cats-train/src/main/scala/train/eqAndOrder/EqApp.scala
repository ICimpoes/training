package train.eqAndOrder

import cats.std.all._
import cats.syntax.partialOrder._
import train._

object EqApp extends App {

  val a1 = A1("a1")
  val a12 = A1("a2")
  val a2 = A2(2)

  2 === 2 printMe

  //Needs implicit Eq
  a1 === a12 printMe

//    a2 === a1
  1 > 1.2 printMe

  //  1 compare 1.2
}
