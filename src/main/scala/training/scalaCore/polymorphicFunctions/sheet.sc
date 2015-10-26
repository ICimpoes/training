import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

type JsonWriter[T] = T => Int
type F[A] = (String, A, Map[String, String]) => Future[Int]
def function[A <% Int](db: String, content: A, attrs: Map[String, String] = Map.empty) : Future[Int] = {
  Future {content + 5 }
}
//def function[T](p: T, s: String) = p.toString + s
def b[A: JsonWriter](t: A, a: F[A]): Future[Int] = a("3", t, Map.empty)

implicit val w: JsonWriter[List[Int]] = _.head

Await.result(b(List(2, 3, 4), function[List[Int]]), 1.second)
//def f1[A, B](a: A, b: B) = a.toString + b
//def f2[A, B](b: Int, a: A, fa: (A, B) => String) = fa.curried(a) andThen( _ + b )
//f2[List[Int], Int](3, List(1, 2, 3), f1)(2)