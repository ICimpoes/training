package train.typeclass

trait CanAppend[A] {

  def append(x: A, y: A): A

}

object CanAppend {

  def apply[A: CanAppend]: CanAppend[A] = implicitly

  trait Ops[A] {
    def typeClassInstance: CanAppend[A]
    def self: A
    def |+|(y: A): A = typeClassInstance.append(self, y)
  }

  object ops {
    implicit def toAllCanAppendOps[A: CanAppend](target: A): Ops[A] = new Ops[A] {
      val self = target
      val typeClassInstance = CanAppend[A]
    }
  }

  object implicits {

    implicit val intTruthy: CanAppend[Int] = new CanAppend[Int] {
      override def append(x: Int, y: Int): Int = {
        x + y
      }
    }

    implicit val stringTruthy: CanAppend[String] = new CanAppend[String] {
      override def append(x: String, y: String): String = x + y
    }
  }
}
