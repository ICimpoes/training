package train.future.welcomeToTheFuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Main extends App {

  // this is needed to not block in for-comprehension
  val g = grind("bean")
  val hW = heatWater(Water(0))
  val temperatureOkay: Future[Boolean] = hW map { water =>
    println("we're in the future!")
    (80 to 85).contains(water.temperature)
  }
  val fM = frothMilk("milk")
  //

  for {
    c <- g
    w <- hW
    m <- fM
    oK <- temperatureOkay
    if oK
    e <- brew(c, w)
  } yield println(e)

  //-------Test Promise

  val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
  println("--------------------TEST PROMISE--------------------")
  println("Now that they're elected, let's see if they remember their promises...")
  taxCutF.onComplete {
    case Success(TaxCut(reduction)) =>
      println(s"A miracle! They really cut our taxes by $reduction percentage points!")
    case Failure(ex) =>
      println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
  }

  val taxCutFailed: Future[TaxCut] = Government.redeemCampaignPledgeFailed()
  taxCutFailed.onComplete {
    case Success(TaxCut(reduction)) =>
      println(s"A miracle! They really cut our taxes by $reduction percentage points!")
    case Failure(ex) =>
      println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
  }

  Thread.sleep(10000)

}
