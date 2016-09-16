package demo

trait CanTransform[T, R] {

  def transform(x: T): R

}


object CanTransform {

  trait Ops[T] {
    def self: T
    def |->[R](implicit ev: CanTransform[T, R]) = ev.transform(self)
  }

  object Ops {
    implicit def toAllTransfrom[T, R](target: T)(implicit ev: CanTransform[T, R]) = new Ops[T] {
      override def self: T = target
    }
    implicit def lift[T, R](tr: T => R): CanTransform[T, R] = new CanTransform[T, R] {
      override def transform(x: T): R = tr(x)
    }
  }

  object implicits {
    import Ops._
    implicit val stringToBoolean: CanTransform[String, Boolean] = (_: String).nonEmpty
    implicit val stringToInt: CanTransform[String, Int] = (_: String).length
    implicit val intToBoolean: CanTransform[Int, Boolean] = (_: Int) != 0
  }


}