package puzzle

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object App2 extends App {

  val y = 500

  def intFutture(from: Int, to: Int): Future[Int] = {
    Future {
      evaluate(from, to)
    }
  }

  def evaluate(from: Int, to: Int): Int = {
    val until = y / (_: Int) + 1
    var res = 0
    for (a <- Range(from, to)) {
      for (b <- Range(0, until(2))) {
        for (c <- Range(0, until(3))) {
          for (d <- Range(0, until(5))) {
            for (e <- Range(0, until(7))) {
              if (a * 1 + b * 2 + c * 3 + d * 5 + e * 7 == y) {
//                println(s"1 * $a; 2 * $b; 3 * $c; 5 * $d; 7 * $e")
                res += 1
              }
            }
          }
        }
      }
    }
    res
  }

  //1, 2, 3, 7
  // 10
  //
  //for (a <- x) {
  //  if (y % a == 0) result += 1
  //  for (b <- List(3, 5)) {
  //    if (y % a + b == 0) result += 1
  //    if (y % b == 0) result += 1
  //    for (c <- List(5)) {
  //      if (y % a + b + c == 0) result +=1
  //      if(y)
  //    }
  //  }
  //}
  {
    println("future")
    val threads = 4
    val t = System.currentTimeMillis()
    val f1 = intFutture(0, y / threads)
    val f2 = intFutture(y / threads, 2 * y / threads)
    val f3 = intFutture(2 * y / threads, 3 * y / threads)
    val f4 = intFutture(3 * y / threads, y + 1)
    val result = for {
      a <- f1
      b <- f2
      c <- f3
      d <- f4
    } yield a + b + c + d
    val r = Await.result(result, 1.day)
    println(s"result = $r")
    println(s"time spent: ${System.currentTimeMillis() - t}")
  }
  {
    println("present")
    val t = System.currentTimeMillis()
    println(s"result = ${evaluate(0, y + 1)}")
    println(s"time spent: ${System.currentTimeMillis() - t}")
  }

}
