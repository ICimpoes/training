package code_competition_2016.first

import util._

object ResolveAddition {

  def apply(inPath: String, outPath: String) = {

    val fileLines = readFile(inPath)
    val num = fileLines.next().toInt
    val result = Range(0, num).foldLeft(List[String]()) { (l, _) =>
      val f = fileLines.next()
      val s = fileLines.next()
      val res = ElementaryAdd(f, s)
      l.:+(res)
    }
    writeToFile(outPath, result.mkString("\n"))
  }

}
