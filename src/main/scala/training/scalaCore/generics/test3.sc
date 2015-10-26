import scala.util.{Success, Try}
type Pipe[-T, +R] = (T) => Try[R]
type Mapping[R] = (R) => Try[String]

trait Check[T, R] {
  def request: T
  def pipe: Pipe[T, R]
  def mapping: Mapping[R]

  def check = pipe(request) map mapping
}

class IntHealth(r: Int) extends Check[Int, Int] {
  val request: Int = r
  val pipe = intPipe
  val mapping = intMapping
}

class StringHealth(r: String) extends Check[String, String] {
  val request: String = r
  val pipe = stringPipe
  val mapping = defMapping
}

class StringToIntHealth(r: String) extends Check[String, Int] {
  val request: String = r
  val pipe = stringToIntPipe
  val mapping = intMapping
}

def intMapping: Mapping[Int] = (v: Int) => Success(v.toString)
def defMapping: Mapping[String] = Success(_: String)
def intPipe: Pipe[Int, Int] = Success(_)
def stringPipe: Pipe[String, String] = Success(_)
def stringToIntPipe: Pipe[String, Int] = (s) => Try { s.toInt }

def checkMultiple(in: Seq[Check[_, _]]) = {
  in map { _.check }
}
val one = new IntHealth(1)
val two = new StringHealth("aa")
val three = new StringToIntHealth("1")
val seq = Seq(one, two, three)
checkMultiple(seq)
