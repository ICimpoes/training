package code_competition_2016.first

import org.scalatest.concurrent.Timeouts
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{Matchers, WordSpecLike}
import util._

class AdditionSpec extends WordSpecLike with Matchers with Timeouts {

  val timeLimit = Span(5, Seconds)

  val workingDir = getClass.getResource("/addition").getPath
  val outPath = "target"

  "Addition" should {
    "correctly resolve first input" in {
      val in = s"$workingDir/addition1.in"
      val out = s"$workingDir/addition1.out"
      val resultOut = s"$outPath/out1.out"

      failAfter(timeLimit) {
        ResolveAddition(in, resultOut)
      }

      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
    "correctly resolve second input" in {
      val in = s"$workingDir/addition2.in"
      val out = s"$workingDir/addition2.out"
      val resultOut = s"$outPath/out2.out"

      failAfter(timeLimit) {
        ResolveAddition(in, resultOut)
      }

      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
    "correctly resolve third input" in {
      val in = s"$workingDir/addition3.in"
      val out = s"$workingDir/addition3.out"
      val resultOut = s"$outPath/out3.out"

      failAfter(timeLimit) {
        ResolveAddition(in, resultOut)
      }

      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
    "correctly resolve dorth input" in {
      val in = s"$workingDir/addition4.in"
      val out = s"$workingDir/addition4.out"
      val resultOut = s"$outPath/out4.out"

      failAfter(timeLimit) {
        ResolveAddition(in, resultOut)
      }
      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected

    }

  }
}
