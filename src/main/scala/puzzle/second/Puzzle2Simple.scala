package puzzle.second

object Puzzle2Simple extends App {

  var result = 0
  val y = 15
  val t = System.currentTimeMillis()
//  for (a <- Range(0, 1501)) {
//    val tmp1 = y - a
//    if (tmp1 % 7 == 0 || tmp1 % 11 == 0 || tmp1 % 15 == 0 || tmp1 % 20 == 0)
//      for (b <- Range(0, 215)) {
//        val tmp2 = y - a - b * 7
//        if (tmp2 % 11 == 0 || tmp2 % 15 == 0 || tmp2 % 20 == 0)
//          for (c <- Range(0, 137)) {
//            val tmp3 = y - a - b * 7 - c * 11
//            if (tmp3 % 15 == 0 || tmp3 % 20 == 0)
//              for (d <- Range(0, 101)) {
//                val tmp4 = y - a - b * 7 - c * 11 - d * 15
//                if (tmp4 % 20 == 0)
//                  for (e <- Range(0, 76)) {
//                    if (a * 1 + b * 7 + c * 11 + d * 15 + e * 20 == y) {
//                      result += 1
//                    }
//                  }
//              }
//          }
//      }
//  }

  for (a <- Range(0, 16)) {
    val tmp1 = 15 - a
//    if (tmp1 % 2 == 0 || tmp1 % 3 == 0 || tmp1 % 5 == 0)
      for (b <- Range(0, 8)) {
        val tmp2 = y - a - b * 2
//        if (tmp2 % 3 == 0 || tmp2 % 5 == 0)
          for (c <- Range(0, 6)) {
            val tmp3 = y - a - b * 2 - c * 3
//            if (tmp3 % 5 == 0)
              for (d <- Range(0, 4)) {
                if (a * 1 + b * 2 + c * 3 + d * 5 == y) {
                  println(s"1 * $a; 2 * $b; 3 * $c; 5 * $d")
                  result += 1
                }
              }
          }
      }
  }
  println(System.currentTimeMillis() - t)
  println(result)

}
