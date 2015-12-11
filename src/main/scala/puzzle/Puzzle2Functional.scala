package puzzle

//object Puzzle2Functional extends App {
//
//  val y = 15
//  val x = List(1, 2, 3, 5, 7).map(_ -> 0).toMap
//  for (k <- x.keys) {
//    if (x.values.sum == 0) res += 1
//
//  }
//  var res = 0
//  def rec(list: List[Int], sum: Int, res): Int = {
//    list match {
//      case head :: Nil => for(a <- Range(0, y / head + 1)) if (sum + head * a == y) {res += 1} else {}
//      case head :: tail => for(a <- Range(0, y / head + 1)) rec(tail, sum + head * a, res)
//    }
//  }
//}
