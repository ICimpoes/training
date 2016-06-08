package train

import cats.{Applicative, Apply}
import train.functor._
import cats.syntax.apply._

package object applyAndApplicative {

  /**
   * It's a weaker version of Applicative, which doesn't contain `pure`
   * @see [[http://eed3si9n.com/herding-cats/Apply.html]]
   */
  trait WrapperApply extends Apply[Wrapper]{
    /**
     * Takes a train.functor that has a function in it and another train.functor
     * and extracts that function from the first train.functor and then maps it over the second one.
     */
    def ap[A, B](fa: Wrapper[A])(f: Wrapper[A => B]): Wrapper[B] = {
      (fa, f) match {
        case (Value(v), Value(fun)) => Value(fun(v))
        case _ => NoValue
      }
    }
  }

  /**
   * Takes a list of applicatives and returns an applicative that has a list as its result value.
   */
  def sequenceA[F[_]: Applicative, A](list: List[F[A]]): F[List[A]] = list match {
    case Nil     => Applicative[F].pure(Nil)
    case x :: xs => (x |@| sequenceA(xs)) map {_ :: _}
  }

  /**
   * Defines two methods, pure and ap
   * @see [[http://eed3si9n.com/herding-cats/Applicative.html]]
   */
  trait WrapperApplicative extends Applicative[Wrapper] {
    /**
     * Pure should take a value of any type and return an applicative value with that value inside it.
     * A better way of thinking about pure would be to say that it takes a value and puts it in some sort of default
     * (or pure) context - a minimal context that still yields that value.
     */
    def pure[A](x: A): Wrapper[A] = Value(x)
  }

  implicit val wrapperApply: Apply[Wrapper] = new WrapperApply with WrapperFunctor

  implicit val wrapperApplicative: Applicative[Wrapper] = new WrapperApplicative with WrapperApply

}
