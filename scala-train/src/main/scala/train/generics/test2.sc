import scala.util.{Success, Try}

type Pipe[-T, +R] = (T) => Try[R]

type Mapping[R] = (R) => Try[String]

type Check[T, R] = (T, Mapping[R])

def intMapping: Mapping[Int] = (v: Int) => Success(v.toString)

def defMapping: Mapping[String] = Success(_: String)

def intPipe: Pipe[Int, Int] = Success(_)

def stringPipe: Pipe[String, String] = Success(_)

def stringToIntPipe: Pipe[String, Int] = (s) => Try { s.toInt }

def checkMultiple[T, R](in: Seq[Check[_, _]]) = {
  in map {
    case (request: Int, mapping) => intPipe(request) map mapping.asInstanceOf[Mapping[Int]]
    case (request: String, mapping) => stringPipe(request) map mapping.asInstanceOf[Mapping[String]]
  }
}

val one = (1, intMapping)
val two = ("aa", defMapping)
val three = ("1", intMapping)

val seq = Seq(one, two, three)

checkMultiple[Any, Any](seq)
