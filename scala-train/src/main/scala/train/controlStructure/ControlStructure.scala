package train.controlStructure

import scala.concurrent.Future

object ControlStructure extends App {

  def dont(code: => Unit) = new DontCommand(code)

  class DontCommand(code: => Unit) {
    def unless(condition: => Boolean) =
      if (condition) code

    def until(condition: => Boolean) = {
      while (!condition) {}
      code
    }
  }

  @volatile
  var a = 6
  println("a = 6")

  import scala.concurrent.ExecutionContext.Implicits.global
  Future {
    dont {
      println("Five")
    } until (5 == a)
  } onComplete{
    case x => x
  }

  Thread.sleep(1000)
  a = 5
  println("a = 5")
  Thread.sleep(100)

}
