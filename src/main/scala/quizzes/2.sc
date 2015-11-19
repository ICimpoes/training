import java.io.{FileWriter, PrintWriter}

import scala.io.Source

//val writer = new PrintWriter(new FileWriter("aaa"))
Source.fromFile(s"${getClass().getResource("").getPath}/file.txt").foreach(print)
//writer.close()


