package demo

import scala.reflect.ClassTag

/**
  * Transform one object to another
  */
trait CanTransform[T, R] {

  def transform(x: T): R

}


object CanTransform {

  /**
    * CanTransform operation.
    * Implementing this trait you can transform one object to another just like that
    * {{{
    *   obj1.|->[R]
    * }}}
    */
  trait Ops[T] {
    def self: T
    def |->[R: ClassTag](implicit ev: CanTransform[T, R]) = ev.transform(self)
  }

  object Ops {
    /**
      * Implicit conversation to CanTransform Ops. Implicit CanTransform must be provided.
      * Now you can use this syntax
      * {{{
      *   obj1.|->[R]
      * }}}
      * just by importing this function.
      */
    implicit def toAllTransform[T, R](target: T)(implicit ev: CanTransform[T, R]) = new Ops[T] {
      override def self: T = target
    }

    /**
      * Implicitly convert your function T => R into a `CanTransform[T, R]` instance.
      * Now you can implement CanTransform trait like this:
      * {{{
      *   implicit val stringToBoolean: CanTransform[String, Boolean] = (_: String).nonEmpty
      * }}}
      * instead of
      * {{{
      *   implicit val stringToBoolean: CanTransform[String, Boolean] = new CanTransform[T, R] {
      *     override def transform(x: String): Boolean = x.nonEmpty
      *   }
      * }}}
      */
    implicit def lift[T, R](tr: T => R): CanTransform[T, R] = new CanTransform[T, R] {
      override def transform(x: T): R = tr(x)
    }
  }

  /**
    * Default implicit implementations for build-n types.
    */
  object implicits {
    import Ops._
    implicit val stringToBoolean: CanTransform[String, Boolean] = (_: String).nonEmpty
    implicit val stringToInt: CanTransform[String, Int] = (_: String).length
    implicit val intToBoolean: CanTransform[Int, Boolean] = (_: Int) != 0
  }


}