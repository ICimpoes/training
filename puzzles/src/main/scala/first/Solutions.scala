package first

object Solutions extends App {

  def one(s: String): String = {
    var list: List[(Char, Int)] = List()
    s.foreach { c =>
      list match {
        case (chr, cnt) :: tail if chr == c =>
          list = chr -> (cnt + 1) :: tail
        case _ =>
          list = c -> 1 :: list
      }
    }
    list.reverse.map(x => s"${x._1}${x._2}") reduce ((x, y) => x + y)
  }

  println(one(input))

}
