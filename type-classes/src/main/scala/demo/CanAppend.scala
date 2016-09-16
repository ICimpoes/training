package demo


trait CanAppend[T] {

  def append(x: T, y: T): T

}

object CanAppend {

  def apply[A: CanAppend]: CanAppend[A] = implicitly

  trait Ops[T] {
    def typeClassInstance: CanAppend[T]
    def self: T
    def |+|(other: T) = typeClassInstance.append(self, other)
  }

  object Ops {
    implicit def toAllAppend[T: CanAppend](target: T): Ops[T] = new Ops[T] {
      val typeClassInstance: CanAppend[T] = CanAppend[T]
      val self: T = target
    }
  }

  object implecits {
    implicit val canAppendStrings = new CanAppend[String] {
      override def append(x: String, y: String): String = x + y
    }
    implicit val canAppendInts = new CanAppend[Int] {
      override def append(x: Int, y: Int): Int = x + y
    }
  }

}