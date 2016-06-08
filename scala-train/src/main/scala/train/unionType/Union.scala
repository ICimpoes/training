package train.unionType

import train.Print


object Union extends App {

  type -[A] = A => Nothing
  /**
    * Convert type T to ((T) => Nothing) => Nothing
    */
  type --[A] = -[-[A]]

  type v[T, U] = -[-[T] with -[U]]

  implicitly[--[Int] <:< (Int v String)]

  type V[T, U] = {type L[X] = --[X] <:< (T v U)}

  def size[T: (Int V String)#L](t: T) = {
    t match {
      case x: Int =>
        x
      case x: String =>
        x.length
    }
  }

  size(5) printMe()
  size("5") printMe()
  //  size(1.0) printMe() does not compile

}
