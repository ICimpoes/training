import scala.util.Try
def separate() = println("---------------------------------------------------------------------------------")
//--------------------------------------------------
case class Test(x: String, y: Int)
def testPrint(msg: String): PartialFunction[Any, Unit] = {
  case Test(x1, y1) => println(s"$msg: $x1, $y1")
}
val test = Test("rer", 12)
val x = testPrint("adasd")
//------------------------------------------
def modN(n: Int)(x: Int) = x % n == 0
val mod5 = modN(5) _
separate()
//------------------------------------------------------------
val myMap: Map[String, Int] = Map("one" -> 1, "two" -> 2)
def getOrFailure[K, V] (map: Map[K, V])(key: K): Try[V] = {
  map.get(key).fold(Try[V](throw new NoSuchElementException(s"No such key: $key")))(x => Try(x))
}
def getOrFS = getOrFailure(myMap) _
getOrFS("two")
separate()
//-------------------------------------------------------------
val testNull = Test(null, 1) match {
  case Test(text, value) => println(Some(text))
}
separate()
//----------------------------------------------
object GivenNames {
  def unapplySeq(givenNames: String): Option[Seq[String]] = {
    val names = givenNames.split(" ")
    if (names.forall(_.isEmpty)) None
    else Some(names)
  }
}

def greeting(name: String) = {
  name match {
    case GivenNames("Alice", "Bob", _*) => println("Hello")
    case _ => println("Who the fuck are you?")
  }
}

greeting("Alice Bob asd sdas")
separate()
//-------------------------------------------------
trait EventIntentExtractor {
  def intent: String
  def unapply(map: Map[String, String]): Option[String] =
    map collectFirst {case ("a", topic) if topic contains intent => topic}
//    for {
//    topic <- map.get("a")
//    if topic contains intent
//  } yield topic
}
object EventExtractor extends EventIntentExtractor {

  override def intent: String = "one"
}

val myMap2: Map[String, String] = Map("a" -> "oneasd", "b" -> "2")

myMap2 match {
  case EventExtractor(topic) => println(topic)
  case _ => println("Do not match")
}
separate()
//-----------------------------
val tuple = (1, "one")
val t@(y, _) = tuple
t
y
separate()
//-----------------------------------
val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil
for {
  list@List(_, _*) <- lists
} yield list.size
//------------------------------------
val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
  ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] =
  wordFrequencies.collect{case (word, freq) if freq > 3 && freq < 25 => word}

wordsWithoutOutliers(wordFrequencies)
//----------------------------------------
implicit def func2Partial[A,R](f : A => R) : PartialFunction[A,R] = {case x => f(x)}

val pf : PartialFunction[Int, String] = {case 1 => "one"}

val g = pf orElse {_: Int => "default"}
g(0)

val op = Option(null)

myMap2.get("asdfsd").fold(Try[String](throw new Exception))(x => Try(x))