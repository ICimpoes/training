package puzzle.first

object Solutions extends App {


  def one(s: String): String = {
    var list: List[(Int, Char)] = List()
    s.foreach { c =>
      list match {
        case head :: tail if head._2 == c =>
          list = (head._1 + 1) -> c :: tail
        case _ =>
          list = 1 -> c :: list
      }
    }
    list.reverse.map(x => s"${x._1}${x._2}") reduce ((x, y) => x + y)
  }

//  def second(s: String): String = {
//    s"1$s".reduce[String] {
//      (f, s) =>
//        f.toList.reverse match {
//          case head :: num :: tail => ""
//        }
//
//    }
//
//  }


//  def third(s: String): String = {
//    s.zipWithIndex.fold(""){
//      case x =>
//    }
//  }
}
