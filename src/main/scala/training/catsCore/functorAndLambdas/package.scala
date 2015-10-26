package training.catsCore

import cats.Functor

package object functorAndLambdas {
  /**
   * Lambdas:
   *
   * Take a Functor[`F[_]`] where F[_] generic parameter is a type of kind * -> *.
   * Whilst Tuple2 is of kind (*, *) -> *
   * We created a type alias with one parameter that acts like a one parameter type alias * -> *
   * and this is the essence of what the type lambda trick does.
   */
  implicit def aFunctor[X] = new Functor[({type L[?] = (X, ?)})#L] {
    override def map[A, B](fa: (X, A))(f: (A) => B): (X, B) = fa._1 -> f(fa._2)
  }
}
