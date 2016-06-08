package train.monteCarlo

import train.Print

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.Random

object MonteCarloPi {

  private def mcCount(iter: Int): Int = {
    var hits = 0
    for (i <- 0 until iter) {
      val x = Random.nextDouble()
      val y = Random.nextDouble()
      if (x * x + y * y < 1) hits += 1
    }
    hits
  }

  def apply(iter: Int): Double = {
    val start = System.currentTimeMillis()
    println("started execution")
    val res = 4.0 * mcCount(iter) / iter
    println(s"Execution took ${System.currentTimeMillis() - start}")
    res
  }

}

object PiApp extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  val pi1 = Future(MonteCarloPi(Int.MaxValue))
  val pi2 = Future(MonteCarloPi(Int.MaxValue))
  val pi3 = Future(MonteCarloPi(Int.MaxValue))
  val pi4 = Future(MonteCarloPi(Int.MaxValue))
  val pi5 = Future(MonteCarloPi(Int.MaxValue))
  val pi6 = Future(MonteCarloPi(Int.MaxValue))
  val pi7 = Future(MonteCarloPi(Int.MaxValue))

  val pi: Future[Double] = for {
    p1 <- pi1
    p2 <- pi2
    p3 <- pi3
    p4 <- pi4
    p5 <- pi5
    p6 <- pi6
    p7 <- pi7
  } yield (p1 + p2 + p3 + p4 + p5 + p6 + p7) / 7

  Await.result(pi, 1 hour) printMe()

}