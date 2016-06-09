package train

import cats.{Order, Show, Eq}

package object eqAndOrder {

  trait A[+T] {
    def a: T
  }

  case class A1(a: String) extends A[String]

  object A1 {
    implicit val a1Eq = Eq.fromUniversalEquals[A1]
    implicit val shA = Show.fromToString[A1]
    implicit val ordA = new Order[String] {
      override def compare(x: String, y: String): Int = x.compareToIgnoreCase(y)
    }
  }

  case class A2(a: Int) extends A[Int]

  object A2 {
    implicit val a2Eq = Eq.fromUniversalEquals[A2]
    implicit val shA = Show.fromToString[A2]
    implicit val ordA = new Order[Int] {
      override def compare(x: Int, y: Int): Int = x.compare(y)
    }
  }

}
