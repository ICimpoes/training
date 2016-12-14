import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

package object util {

  def writeToFile(path: String, txt: String): Unit = {
    Files.write(Paths.get(path), txt.getBytes(StandardCharsets.UTF_8))
  }

  def readFile(path: String): Iterator[String] =
    scala.io.Source.fromFile(path, "UTF-8").getLines

}
