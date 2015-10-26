import scala.util.{Success, Try}

type Pipe[-T, +R] = (T) => Try[R]

type Mapping[R] = (R) => Try[String]

type Check[T, R] = (T, Pipe[T, R], Mapping[R])

def intMapping: Mapping[Int] = (v: Int) => Success(v.toString)

def defMapping: Mapping[String] = Success(_: String)

def intPipe: Pipe[Int, Int] = Success(_)

def stringPipe: Pipe[String, String] = Success(_)

def stringToIntPipe: Pipe[String, Int] = (s) => Try { s.toInt }

def checkMultiple(in: Seq[Check]) = {
  in map {
    case (r, p: Pipe, m: Mapping) =>
      p(r) map m
  }
}

val one = (1, intPipe, intMapping)
val two = ("aa", stringPipe, defMapping)
val three = ("1", stringToIntPipe, intMapping)

val seq = Seq[Check[_, _]](one, two, three)

checkMultiple(seq)
