import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}
def getInTheFuture(value: Int): Future[Int] = Future {
  if(value == 2) throw new Exception("Not found")
  value
}

val list = List(1, 2, 5)
val f = Future.traverse(list) {
  item => getInTheFuture(item).map(Success(_)).recover{case x => Failure(x)}
}.map(_.filter(_.isSuccess))


val a = Await.result(f, 10000 milli)

