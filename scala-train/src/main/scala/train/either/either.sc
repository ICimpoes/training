
def a(b: Boolean): Either[String, Int] = if (b) Left("one") else Right(1)

val f = false
val t = true

a(f).fold(l => l, r => r.toString)
a(t).fold(l => l, r => r.toString)

a(f).isLeft
a(f).isRight

a(f).right.map(x => a(t))
a(f).right.map(x => a(f))
a(t).right.map(x => a(f))
a(t).right.map(x => a(t))

a(f).right.flatMap(x => a(t))
a(f).right.flatMap(x => a(f))
a(t).right.flatMap(x => a(f))
a(t).right.flatMap(x => a(t))

a(f).left.flatMap(x => a(t))
a(f).left.flatMap(x => a(f))
a(t).left.flatMap(x => a(f))
a(t).left.flatMap(x => a(t))

