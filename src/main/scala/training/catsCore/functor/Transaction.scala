package training.catsCore.functor

import scala.util.{Success, Failure, Try}

//trait Transaction[T <: CanTransact] {
//}
//
//trait SuccessTransaction[T <: CanTransact] extends Transaction[T] {
//}
//
//object FailedTransaction extends Transaction[Nothing]

trait CanTransact {
  val s: Long
  val a: Account

  def -> (that: Account): Try[(Account, Account)] = {
    to(that)
  }

  def to (that: Account): Try[(Account, Account)] = {
    checkTransaction.map(_ => transactMoney(that))
  }

  private def transactMoney(that: Account) = {
    a.copy(sum = a.sum - s) -> that.copy(sum = that.sum + s)
  }

  private def checkTransaction: Try[Account] = {
    if (s <= 0) {
      Failure(TransactionException("Sum must be greater than 0"))
    } else if (a.sum < s) {
      Failure(TransactionException(s"Not enough money on acc ${a.count}"))
    } else {
      Success(a)
    }
  }
}
object CanTransact {
  def apply(acc: Account, sum: Long) = new CanTransact {
    val s: Long = sum
    val a: Account = acc
  }
}

case class Account(count: Int, sum: Long)

object Implicits {
  implicit class RichAccount(val a: Account) {
    def ~ (s: Long) = transact(s)
    def transact(s: Long) = CanTransact(a, s)
  }
}
