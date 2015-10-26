import scala.util.{Failure, Success, Try}

trait EventIntentExtractor {
  def intent: String
  def unapply(map: Map[String, String]): Option[String] =
    map collectFirst { case ("a", topic) if topic contains intent => topic }
  //    for {
  //    topic <- map.get("a")
  //    if topic contains intent
  //  } yield topic

}

object EventExtractor extends EventIntentExtractor {

  override def intent: String = "ones"
}

val myMap2: Map[String, String] = Map("a" -> "oneasd", "b" -> "2")
myMap2 match {
  case EventExtractor(topic) => println(topic)
  case _ => println("Do not match")
}


val myMap: Map[String, Int] = Map("one" -> 1, "two" -> 2)
def getOrFailure[K, V] (map: Map[K, V])(key: K): Try[V] = {
  map.get(key).fold[Try[V]](Failure(new NoSuchElementException(s"No such key: $key")))
  {Success(_)}
}


def getOrFS = getOrFailure(myMap) _
getOrFS("two")
