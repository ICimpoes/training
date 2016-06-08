package train


object FizzBuzz extends App {
  (1 to 100).foreach {
    x =>
      if (x % 15 == 0) println("FizzBuzz")
      else if (x % 3 == 0) println("Fizz")
      else if (x % 5 == 0) println("Buzz")
      else println(x)
  }
}
