package train

import algebra.Eq
import cats.Show

package object eqAndOrder {

  trait A[T] {
    def a: T
  }

  case class A1(a: String) extends A[String]
  object A1 {
    implicit val a1Eq = Eq.fromUniversalEquals[A1]
    implicit val shA = Show.fromToString[A1]
  }

  case class A2(a: Int) extends A[Int]
  object A2 {
    implicit val a2Eq = Eq.fromUniversalEquals[A2]
    implicit val shA = Show.fromToString[A2]

  }
}
