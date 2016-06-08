import train.tr._

import scala.util.{Success, Failure, Try}


/*
 * recover and recoverWith are like map and flatMap
 * recover (pf : PartialFunction[Throwable, U])(...) : Try[U]
 * recoverWith (pf : PartialFunction[Throwable, Try[U]])(...) : Try[U]
 */

//returns Succeeded[Cigarette]
val smokeRecover1 = tryToBuy(Customer(25)).recover {
  case _ => tryToBuy(Customer(5))
}

//returns Succeeded[Failed[_]]
val smokeRecover2 = tryToBuy(Customer(15)).recover {
  case _ => tryToBuy(Customer(5))
}

//returns Succeeded[Cigarette]
val smokeRecover3 = tryToBuy(Customer(15)).recover {
  case _ => new Cigarette(13)
}

//returns Failed[_]
val smokeRecoverWith1 = tryToBuy(Customer(15)).recoverWith {
  case _ => tryToBuy(Customer(5))
}

//returns Succeeded[Cigarette]
val smokeRecoverWith2 = tryToBuy(Customer(15)).recoverWith {
  case _ => tryToBuy(Customer(20))
}

patMatch(smokeRecover1)
patMatch(smokeRecover2)
patMatch(smokeRecover3)
patMatch(smokeRecoverWith1)
patMatch(smokeRecoverWith2)

def patMatch(pat: Try[_]) = {
  pat match {
    case Failure(f) => s"Failed $f"
    case Success(s) => s"Succeeded $s"
  }
}