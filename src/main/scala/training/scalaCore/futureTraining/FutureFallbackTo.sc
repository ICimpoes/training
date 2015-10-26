import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/*
 * recover and recoverWith are like map and flatMap
 * recover (pf : PartialFunction[Throwable, U])(...) : Future[U]
 * recoverWith (pf : PartialFunction[Throwable, Future[U]])(...) : Future[U]
 */

def firstFuture(value: Boolean): Future[String] = Future {
  value match {
    case true => "f_true"
    case false => throw new Exception("first failed")
  }
}

def secondFuture(value: Boolean): Future[String] = Future {
  value match {
    case true => "s_true"
    case false => throw new Exception("first failed")
  }
}

val f = myFallbackTo(firstFuture(false), secondFuture(false))

//implementation of fallbackTo
def myFallbackTo[U](f1: Future[U], f2: Future[U]): Future[U] = {
  f1 recoverWith { case _ => f2 } recoverWith { case _ => f1 }
}

f onSuccess {
  case s => s
}

f onFailure {
  case t => t.getMessage
}

Await.result(f, 10000 milli)
