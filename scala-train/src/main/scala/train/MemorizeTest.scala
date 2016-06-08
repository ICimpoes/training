package train

object MemorizeTest extends App {

  val f1 = (a: Int) => {
    println("in f")
    a * 2
  }

  val x = memorize(f1)

  x(2) printMe()
  x(3) printMe()
  x(4) printMe()
  //Here f1(2) is not called
  x(2) printMe()


}

/**
  * Take a pure function f as an argument and returns a function that behaves almost exactly like f,
  * except that it only calls the original function once for every argument,
  * stores the result internally, and subsequently returns this stored result every time it’s called with the same argument.
  */
object memorize {

  def apply[A, B](f: A => B): A => B = memorizef[A, B](f)

  private def memorizef[A, B](f: A => B): A => B = {
    var memo = Map.empty[A, B]

    //add result of f into map
    val add = (a: A) => {
      val x = f(a)
      memo = memo.+(a -> x)
      x
    }

    (a: A) =>
      memo.getOrElse(a, add(a))
  }
}