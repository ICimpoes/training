package quizzes

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Second extends App {

  val future1 = Future {
    Thread.sleep(1000)
    (1 to 1000).sum
  }

  val future2 = Future {
    Thread.sleep(1000)
    (-1000 to -1).sum
  }

  //in parallel
  val t1 = System.currentTimeMillis()
  (for {
    res1 <- future1
    res2 <- future2
  } yield res1 + res2)
    .onComplete {
      case x =>
        println(x)
        println(System.currentTimeMillis() - t1)
    }

  //sequentially
  val t2 = System.currentTimeMillis()
  (for {
    res1 <- Future {
      Thread.sleep(1000)
      (1 to 1000).sum
    }
    res2 <- Future {
      Thread.sleep(1000)
      (-1000 to -1).sum
    }
  } yield res1 + res2)
    .onComplete {
      case x =>
        println(x)
        println(System.currentTimeMillis() - t2)
    }

  Thread.sleep(4000)


}
