
//def f(x: Int, y: Int) = {
//  require(x >= y)
//  x - y
//}
//f(5, 3)
//f(5, 6)
def mult(x: Int, y: Int) = {
  println(s"x = $x; y = $y")
  x * y
}
val valMult2 = {
  println(s"valMult2")
  mult(_: Int, 2)
}

def defMult2(x: Int) = {
  println(s"defMult3")
  mult(x, 2)
}
valMult2(6)
valMult2(7)
valMult2(8)
defMult2(6)
defMult2(7)
defMult2(8)


case class User(username: String, age: Int)
val user = User("name", 12)

//name
user.productElement(0)
//12
user.productElement(1)