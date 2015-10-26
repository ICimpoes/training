package training.catsCore

import cats.Apply
import training.catsCore.functor._

package object apply {

  implicit val wrapperApply = new Apply[Wrapper] with WrapperFunctor {
    def ap[A, B](fa: Wrapper[A])(f: Wrapper[(A) => B]): Wrapper[B] = {
      f match {
        case Value(v) => map(fa)(v)
        case NoValue => NoValue
      }
    }
  }

}
