package training.catsCore.typeclass

/**
 * @see [[https://github.com/mpilquist/simulacrum]]
 */
trait CanTruthy[A] {
  self =>
  /** Return true, if `a` is truthy. */
  def truthy(a: A): Boolean
}

object CanTruthy {

  def apply[A: CanTruthy]: CanTruthy[A] = implicitly

  object ops {
    implicit def lift[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
      def truthy(a: A): Boolean = f(a)
    }
    implicit def toAllCanTruthyOps[A: CanTruthy](target: A): Boolean = {
      CanTruthy[A].truthy(target)
    }
  }

  object implicits {
    import ops.lift

    implicit val intTruthy: CanTruthy[Int] = {
      x: Int =>
        if (x == 0)
          false
        else
          true
    }

    implicit val stringTruthy: CanTruthy[String] = {
      s: String =>
        if (s.trim.isEmpty)
          false
        else
          true
    }
  }
}

