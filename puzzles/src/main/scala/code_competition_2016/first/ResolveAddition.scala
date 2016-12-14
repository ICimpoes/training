package code_competition_2016.first

import util._

object ResolveAddition {

  /**
    * Read sets from file, add them and write result into out file
    * @param inPath input file path
    * @param outPath output file path
    */
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
