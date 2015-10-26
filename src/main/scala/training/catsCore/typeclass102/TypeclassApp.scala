package training.catsCore.typeclass102

import cats.syntax.eq._
import training._

object TypeclassApp extends App {

  TrafficLight.green === TrafficLight.red printMe()
  TrafficLight.green === TrafficLight.green printMe()
  TrafficLight.green === TrafficLight.yellow printMe()

  //TrafficLight.Green === TrafficLight.Yellow

}
