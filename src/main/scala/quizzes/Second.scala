package quizzes

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Second extends App {

  val future1 = Future { Thread.sleep(1000);(1 to 1000).fold(0)(_ + _) }
  val future2 = Future {  Thread.sleep(1000);(-1000 to -1).fold(0)(_ + _) }
val t1 = System.currentTimeMillis()
  (for {
    res1 <- future1
    res2 <- future2
  } yield res1 + res2).onComplete{case x => println(x)
println(System.currentTimeMillis() - t1)}

  val t2 = System.currentTimeMillis()
  (for {
      res1 <- Future {  Thread.sleep(1000);(1 to 1000).fold(0)(_ + _) }
        res2 <- Future {  Thread.sleep(1000);(-1000 to -1).fold(0)(_ + _) }
  } yield res1 + res2
    ).onComplete{case x => println(x)
  println(System.currentTimeMillis() - t2)}

Thread.sleep(4000)


}
