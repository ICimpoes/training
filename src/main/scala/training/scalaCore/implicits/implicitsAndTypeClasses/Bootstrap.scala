package training.scalaCore.implicits.implicitsAndTypeClasses

import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.{Person, Dog}

object Bootstrap extends App {
  val p = Person("Bob")
  val d = Dog("Rex")

  val first ={
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.FirstVariant
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.FirstVariant._

    print("first: ")
    FirstVariant.speak(p, PersonCanSpeak)
  }

  val second ={
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.SecondVariant
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.Implicits._
    print("second: ")
    SecondVariant.speak(p)
  }

  val third ={
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.ThirdVariant
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.Implicits._

    print("third: ")
    ThirdVariant.speak(p)
  }

  val fourth ={
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.FourthVariant._
    import training.scalaCore.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.Implicits._

    print("fourth: ")
    p.speak()
    d.speak()
  }
}
