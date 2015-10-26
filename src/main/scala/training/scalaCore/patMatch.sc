val list = List("a", "b")

val a = "a"

if (a == "a") println(a)
else if (a == "b") println(a)
else println(a)


val subId = Option(List("1", "3"))

val s = Option(List("1", "2"))

s.getOrElse(Nil).diff(subId.getOrElse(Nil))

def pFunc: PartialFunction[Boolean, Unit] = {
    case bool@true => bool match {
      case false => println("false")
    }
    case false => println("false")
}

pFunc.isDefinedAt(true)

pFunc(false)
class Document {
  def setTitle(title: String): this.type = {
    this
  }
}

class Book extends Document {
  def setAuthor(author: String): this.type = {
    this
  }
}

new Book setTitle "" setAuthor ""
object test {
  object a
  {
    val x = 1
  }

  object b
  // oops, extra newline disassociates this block with the object b

  {
  val x = 1
  }
}
test.b.x