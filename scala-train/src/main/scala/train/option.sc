//-----------------------------------
val list1 = Option(List(1, 2, 3)) match {
  case Some(list@List(_, _*)) => list
  case _ => List(1, 2, 3)
}

Option[String](null).toList
Option[String]("1").toList
Option[List[String]](List("1", "2")).toList


object MessageExtractor {
  def unapply(message:  Map[String, String]): Option[(String, String, Option[String])] = {
    for {
      first <- message.get("1")
      second <- message.get("2")
      third = message.get("3")
    } yield (first, second, third)
  }
}

case class A(id : Boolean)
case class B(a : Option[A])

val s: String = Map[String, String]("1" -> "1", "2" -> "2", "3" -> "3")("1")

val b: B = B(Some(A(true)))

val c: Boolean = b.a.fold(false)(_.id)

case class State(id: String, value: String)

val s1 = State("1", "a")
val s2 = State("2", "b")
val s3 = State("3", "c")


val list2: Option[List[State]] = None//Option(List(s1, s2, s3))

list2.getOrElse(List()).exists(s => s.id == "1" && s.value == "a")
//steps extractor
abstract class Foo(a: String)
case class Foo1(a1: String) extends Foo(a1)
case class Foo2(a2: String) extends Foo(a2)
case class Bar(f : Option[Foo])
object Foo {
  def unapply(b: Bar): Option[String] = {
    for {
      Foo1(a) <- b.f
    } yield a
  }
}

Bar(Some(Foo1("a"))) match {
  case b@Foo(a) => println(s"$b - $a")
}
//-------------------------

val a1 = Some("12")
val a2 = 2
a1.map(_ => a2)