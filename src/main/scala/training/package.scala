package object training {
  implicit class Print[T](a: => T) {
    def printMe() = {
      println(a)
    }
  }
}
