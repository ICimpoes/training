package training.scalaCore.factorial

object Factorial extends App {

  def Y[A, B](f: (A => B) => (A => B)) = {
    case class W(wf: W => (A => B)) {
      def apply(w: W): A => B = wf(w)
    }
    val g: W => A => B = w => f(w(w))(_)
    g(W(g))
  }

  val a: (Int => Int) => (Int => Int) = x => i => if (i <= 1) 1 else x(i - 1) * i

  val factorial = Y[Int, Int](a)
  println(factorial(6))

}
