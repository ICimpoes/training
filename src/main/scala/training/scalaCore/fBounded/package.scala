package training.scalaCore

package object fBounded {

  /**
   * AKA ''recursive type'' or ''self-referential type''
   *
   * <br/>
   * Sometimes it's necessary to access a concrete subclass in a generic trait.
   * {{{
   *      trait Container extends Ordered[Container]
   *
   *      class MyContainer extends Container {
   *        // This now necessitates the compare method
   *        override def compare(that: Container): Int = ???
   *      }
   * }}}
   *
   * @see [[https://twitter.github.io/scala_school/advanced-types.html#fbounded]]
   */
  trait Container[T <: Container[T]] extends Ordered[T]

  class MyContainer extends Container[MyContainer] {
    override def compare(that: MyContainer): Int = ???
  }

}
