package training.catsCore.typeclass

import training._


object TypeclessApp extends App {

  {
    import training.catsCore.typeclass.CanAppend.implicits._
    import training.catsCore.typeclass.CanAppend.ops._

    1 |+| 2 printMe()
    "asdasd" |+| "aasdad" printMe()
  }

  {
    import training.catsCore.typeclass.CanTruthy.implicits._
    import training.catsCore.typeclass.CanTruthy.ops._

    val x: Boolean = 0

    {if (x || "a") {
      true
    } else {
      false
    }} printMe()
  }



}
