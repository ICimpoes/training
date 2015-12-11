import training.scalaCore.tryTraining._

/*
 * for comprehensions wraps it into Try[_]
 */
val smoking1 = for {
  c <- tryToBuy(Customer(15))
  s <- failedSmoking(c)
} yield s

val smoking2 = for {
  c <- tryToBuy(Customer(20))
  s <- failedSmoking(c)
} yield s

val smoking3 = for {
  c <- tryToBuy(Customer(20))
  s <- smokeACigarette(c)
} yield s

tryToBuy(Customer(25)).map(c => c).flatMap(smokeACigarette)
//===
tryToBuy(Customer(25)).flatMap(smokeACigarette)