package demo.draw

/**
  * Created by iliacimpoes on 14.09.16.
  */
object Maiªn extends App {

  implicit val drawCircle = new Draw[Circle] {
    override def draw(x: Circle): Unit = println(s"drawing a circle with radius ${x.radius}")
  }

  implicit val drawTriangle = new Draw[Triangle] {
    override def draw(x: Triangle): Unit = println(s"drawing a triangle ${x.a}, ${x.b}, ${x.c}")
  }

  implicit val drawSquare = new Draw[Square] {
    override def draw(x: Square): Unit = println(s"drawing a Square ${x.side}")
  }

  import Draw.Ops._

  Circle(12).|==>
  Square(12).|==>
  Triangle(12, 13, 14).|==>

}
