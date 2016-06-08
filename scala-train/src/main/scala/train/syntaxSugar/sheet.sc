type ~>[T, R] = PartialFunction[T, R]

val a : Int ~> String = {
  case v if v < 0 => s"Negative ${(-v).toString}"
  case v if v > 0 => s"Positive ${v.toString}"
  case _ => s"Zero"
}
//Is the same as above
val b: Int PartialFunction String = ???

type B[X, Y] = Map[X,Y]
type A[X, Y, Z] = Map[X,Y B Z]