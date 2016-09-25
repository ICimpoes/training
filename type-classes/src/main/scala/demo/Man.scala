package demo

case class Man(name: String, age: Int) {
  val gender = Gender.Male
}

object Man {
  import CanTransform.Ops.lift
  implicit val manToWoman: CanTransform[Man, Woman] = {
    (m: Man) =>
      println("Man, You'll be a woman soon")
      Woman(m.name, m.age)
  }
}