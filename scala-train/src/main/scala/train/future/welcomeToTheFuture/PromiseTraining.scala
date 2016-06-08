package train.future.welcomeToTheFuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

object Government {

  def redeemCampaignPledge(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
      p.success(TaxCut(20))
      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future
  }

  def redeemCampaignPledgeFailed(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
      p.failure(LameExcuse("global economy crisis"))
//      p.complete(Try{throw LameExcuse("global economy crisis")})
      println("We didn't fulfill our promises, but surely they'll understand.")
    }
    p.future
  }

}

case class TaxCut(reduction: Int)

case class LameExcuse(msg: String) extends Exception(msg)