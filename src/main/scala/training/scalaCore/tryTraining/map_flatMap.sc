import training.scalaCore.tryTraining._

import scala.util.{Success, Failure, Try}

//------------- flat map -vs- map -----------------
/*
 * def map[U](f : T => U) : Try[U]
 * in this case f: Cigarette => Try[String].(U - Try[String]).
 * So eventually you get Try[Try[String]]
 */
val smokeF = tryToBuy(Customer(15)).map(smokeACigarette)
val smokeSF = tryToBuy(Customer(20)).map(failedSmoking)
val smokeSS = tryToBuy(Customer(20)).map(smokeACigarette)

/*
 * def flatMap[U](f : T => Try[U]) : Try[U]
 * in this case f: Cigarette => Try[String].
 * Try[U] - Try[String]
 * So eventually you get Try[String]
 */

val smokeFlatF = tryToBuy(Customer(15)).flatMap(smokeACigarette)
val smokeFlatSF = tryToBuy(Customer(15)).flatMap(failedSmoking)
val smokeFlatSS = tryToBuy(Customer(20)).flatMap(smokeACigarette)

patMatch(smokeF)
patMatch(smokeSF)
patMatch(smokeSS)

patMatch(smokeFlatF)
patMatch(smokeFlatSF)
patMatch(smokeFlatSS)

def patMatch(pat: Try[_]) = {
  pat match {
    case Failure(f) => s"Failed $f"
    case Success(s) => s"Succeeded $s"
  }
}
//------------------------------------------