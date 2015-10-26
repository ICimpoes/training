//There is call by name because if otherwise the exception is thrown during substitution
implicit class Recoverable[A](f: => A) {
  def recover(g: Throwable => A): A = {
    try {
      f
    } catch {
      case t: Throwable =>
        g(t)
    }
  }
}


def thisThrows(): String = throw new Exception("Exc")

val s = thisThrows() recover {
  t =>
    println(t)
    ""
}

for {
  sub <- Some("1")
  planVersions@List(_, _*) <- None
} yield (sub, planVersions)