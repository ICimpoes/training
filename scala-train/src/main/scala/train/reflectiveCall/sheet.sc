type Named = {
  def name: String
}
case class SomeType(name: String, field: Int)
case class UnrelatedType(other: Boolean, name: String)
case class WrongType(other: Boolean, notName: String)
def doSomething(named: Named): Unit = {
  println(s"Name: ${named.name}")
}
doSomething(SomeType("a", 12))
doSomething(UnrelatedType(false, "unrelated"))
//don't compile
//doSomething(WrongType(false, "unrelated"))
//------------------------------------------------------
/**
 * AKA structural types
 *
 * @see [[https://twitter.github.io/scala_school/advanced-types.html#structural]]
 */
def doSomethingElse(named: {def name: String}) = {
  println(s"Name2: ${named.name}")
}

doSomethingElse(SomeType("a", 12))
doSomethingElse(UnrelatedType(false, "unrelated"))
//don't compile
//doSomethingElse(WrongType(false, "unrelated"))
