package code_competition_2016.second

import util._

import scala.annotation.tailrec

object ResolveCrypto {

  /**
    * Read sets from file, add them and write result into out file
    * @param inPath input file path
    * @param outPath output file path
    */
  def apply(inPath: String, outPath: String) = {

    @tailrec
    def go(lines: Iterator[String], acc: List[String]): List[String] = {
      if (lines.hasNext) {
        val key = lines.next()
        if (key == "THEEND") acc
        else {
          val text = lines.next()
          val result = CryptoColumns(key, text)
          go(lines, result :: acc)
        }
      } else {
        acc
      }
    }

    val fileLines: Iterator[String] = readFile(inPath)

    writeToFile(outPath, go(fileLines, Nil).reverse.mkString("\n"))
  }

}
