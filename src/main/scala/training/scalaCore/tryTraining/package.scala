package training.scalaCore

import scala.util.Try

package object tryTraining {

  case class Customer(age: Int)

  class Cigarette(val price: Int)

  case class UnderAgeException(message: String) extends Exception(message)

  def buyCigarettes(customer: Customer): Cigarette =
    if (customer.age < 16)
      throw UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
    else new Cigarette(20)
  //--------------------------------------------------------------------------------
  def smokeACigarette(cigarette: Cigarette): Try[String] = Try(s"${cigarette.price}")

  def failedSmoking(cigarette: Cigarette): Try[String] = Try(throw new Exception("Can't smoke this shit"))

  def tryToBuy(customer: Customer) = Try(buyCigarettes(customer))

}
