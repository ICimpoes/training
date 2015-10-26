package training.catsCore.functor

import cats.Apply
import cats.std.list.listInstance
import training._

object FunctorApp extends App {


  {
    import Implicits._
    val a1 = Account(1, 100)
    val a2 = Account(2, 200)
    val a3 = Account(3, 0)

    a1 transact 10 to a2 printMe()
    a1 ~ 10 to a2 printMe()
    a1.transact(10) -> a2 printMe()
    a1 ~ 101 -> a2 printMe()
    a1.transact(-101).to(a2) printMe()
  }

}
