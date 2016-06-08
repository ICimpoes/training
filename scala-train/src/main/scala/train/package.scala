package object train {
  implicit class Print[T](a: => T) {
    def printMe() = {
      println(a)
    }
  }
}
