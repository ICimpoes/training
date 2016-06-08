import scala.util._

val list: List[Try[String]] = List(Try("1"), Try("2"), Try(throw new Exception))

def splitResults(responses: List[Try[String]]): (List[String], List[Exception]) = {
  responses.foldLeft(List.empty[String], List.empty[Exception]) {
    case ((acc1, acc2), p) => p match {
      case Success(r: String) =>
        (r :: acc1, acc2)
      case Failure(ex: Exception) =>
        (acc1, ex :: acc2)
    }
  }
}

splitResults(list)

list.partition(_.isSuccess)