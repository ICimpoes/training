package code_competition_2016

import code_competition_2016.second.ResolveCrypto
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{Matchers, WordSpecLike}
import util._

class CryptoSpec extends WordSpecLike with Matchers with Timeouts {

  val timeLimit = Span(5, Seconds)

  val workingDir = getClass.getResource("/crypto").getPath
  val outPath = "target"
  val resultOut = s"$outPath/out.out"

  "Crypto" should {
    "correctly resolve first input" in {
      val in = s"$workingDir/crypto01.in"
      val out = s"$workingDir/crypto01.out"

      failAfter(timeLimit) {
        ResolveCrypto(in, resultOut)
      }

      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
    "correctly resolve second input" in {
      val in = s"$workingDir/crypto02.in"
      val out = s"$workingDir/crypto02.out"

      failAfter(timeLimit) {
        ResolveCrypto(in, resultOut)
      }

      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
    "correctly resolve third input" in {
      val in = s"$workingDir/crypto03.in"
      val out = s"$workingDir/crypto03.out"

      failAfter(timeLimit) {
        ResolveCrypto(in, resultOut)
      }

      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
    "correctly resolve forth input" in {
      val in = s"$workingDir/crypto04.in"
      val out = s"$workingDir/crypto04.out"

      failAfter(timeLimit) {
        ResolveCrypto(in, resultOut)
      }
      val expected = readFile(out).toList
      val actual = readFile(resultOut).toList
      actual should contain theSameElementsInOrderAs expected
    }
  }
}
