package training.catsCore

import cats.Functor

package object functor {

  trait Wrapper[+T]

  object NoValue extends Wrapper[Nothing]

  case class Value[T](v: T) extends Wrapper[T]

  trait WrapperFunctor extends Functor[Wrapper] {
    def map[A, B](fa: Wrapper[A])(f: (A) => B): Wrapper[B] = {
      fa match {
        case Value(v) => Value(f(v))
        case _ => NoValue
      }
    }
  }

  implicit val wrapperFunctor = new WrapperFunctor {}
}
