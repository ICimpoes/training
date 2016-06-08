package train.typeclass

import train._


object TypeclessApp extends App {

  {
    import train.typeclass.CanAppend.implicits._
    import train.typeclass.CanAppend.ops._

    1 |+| 2 printMe()
    "asdasd" |+| "aasdad" printMe()
  }

  {
    import train.typeclass.CanTruthy.implicits._
    import train.typeclass.CanTruthy.ops._

    val x: Boolean = 0

    {if (x || "a") {
      true
    } else {
      false
    }} printMe()
  }



}
