package demo.draw

import scala.annotation.implicitNotFound

@implicitNotFound("No member of type class Draw in scope for ${T}")
trait Draw[T] {

  def draw(x: T): Unit

}

object Draw {

  def apply[T: Draw]: Draw[T] = implicitly

  trait Ops[T] {
    def typeClassInstance: Draw[T]

    def self: T

    def |==> : Unit = typeClassInstance.draw(self)
  }

  object Ops {
    implicit def allToDraw[T: Draw](target: T) = new Ops[T] {
      val typeClassInstance: Draw[T] = Draw[T]
      val self: T = target
    }
  }

}
