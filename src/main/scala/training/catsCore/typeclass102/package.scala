package training.catsCore

import algebra.Eq

package object typeclass102 {

  sealed trait TrafficLight
  object TrafficLight {

    def red: TrafficLight = Red

    def yellow: TrafficLight = Yellow

    def green: TrafficLight = Green

    case object Red extends TrafficLight

    case object Yellow extends TrafficLight

    case object Green extends TrafficLight

    implicit val trafficLightEq: Eq[TrafficLight] =
      new Eq[TrafficLight] {
        def eqv(a1: TrafficLight, a2: TrafficLight): Boolean = a1 == a2
      }

  }

}
