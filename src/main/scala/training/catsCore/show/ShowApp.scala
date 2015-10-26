package training.catsCore.show

import training.catsCore.eqAndOrder.A1
import cats.syntax.show._

object ShowApp extends App {

  //Needs implicit Show
  println(s"${A1("a").show} aa")

  //  println(s"${new {}.show} aa")

}
