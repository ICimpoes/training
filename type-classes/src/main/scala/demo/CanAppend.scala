package demo


/**
  * Append to objects.
  */
trait CanAppend[T] {

  def append(x: T, y: T): T

}

object CanAppend {

  /**
    * Syntactic sugar.
    * @see http://docs.scala-lang.org/tutorials/FAQ/context-and-view-bounds.html#what-is-a-context-bound
    */
  def apply[A: CanAppend]: CanAppend[A] = implicitly

  /**
    * CanAppend operation.
    * Implementing this trait you can append two objects like this
    * {{{
    *
    *   obj1 |+| obj2
    *
    * }}}
    */
  trait Ops[T] {
    def typeClassInstance: CanAppend[T]
    def self: T
    def |+|(other: T) = typeClassInstance.append(self, other)
  }

  object Ops {
    /**
      * Implicit conversation to CanAppend Ops. Implicit CanAppend must be provided.
      * Now you can use this syntax
      * {{{
      *   obj1 |+| obj2
      * }}}
      * just by importing this function.
      */
    implicit def toAllAppend[T: CanAppend](target: T): Ops[T] = new Ops[T] {
      val typeClassInstance: CanAppend[T] = CanAppend[T]
      val self: T = target
    }
  }

  /**
    * Default implicit implementations for build-n types.
    */
  object implicits {
    implicit val canAppendStrings = new CanAppend[String] {
      override def append(x: String, y: String): String = x + y
    }
    implicit val canAppendInts = new CanAppend[Int] {
      override def append(x: Int, y: Int): Int = x + y
    }
  }

}