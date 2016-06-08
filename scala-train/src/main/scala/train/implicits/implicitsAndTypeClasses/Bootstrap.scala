package train.implicits.implicitsAndTypeClasses

import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses._

object Bootstrap extends App {
  val p = Person("Bob")
  val d = Dog("Rex")

  val first ={
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.FirstVariant
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.FirstVariant._

    print("first: ")
    FirstVariant.speak(p, PersonCanSpeak)
  }

  val second ={
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.SecondVariant
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.Implicits._
    print("second: ")
    SecondVariant.speak(p)
  }

  val third ={
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.ThirdVariant
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.Implicits._

    print("third: ")
    ThirdVariant.speak(p)
  }

  val fourth ={
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.FourthVariant._
    import train.implicits.implicitsAndTypeClasses.ImplicitsAndTypeClasses.Implicits._

    print("fourth: ")
    p.speak()
    d.speak()
  }
}
