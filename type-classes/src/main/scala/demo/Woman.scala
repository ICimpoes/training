package demo

case class Woman(name: String, age: Int) {
  val gender = Gender.Female
}

object Woman {
  import CanTransform.Ops.lift
  implicit val womanToMan: CanTransform[Woman, Man] = (w: Woman) => Man(w.name, w.age)
}
