package training.scalaCore.implicits.implicitsAndTypeClasses

object  ImplicitsAndTypeClasses {

  case class Person(name: String)
  case class Dog(name: String)

  trait CanSpeak[-A] {
    def say(x: A): String
  }

  //This is for the third variant
  object CanSpeak {
    //It allows you to write 'CanSpeak[A].say(a)'
    // instead of 'implicitly[CanSpeak[A]].say(a)'
    def apply[A: CanSpeak]: CanSpeak[A] = implicitly
  }

  object Implicits {
    implicit object PersonCanSpeak extends CanSpeak[Person] {
      override def say(x: Person): String = s"Hello my name is ${x.name}"
    }
    implicit object DogCanSpeak extends CanSpeak[Dog] {
      override def say(x: Dog): String = s"${x.name} says: Bow Wow!"
    }
  }

  object FirstVariant {

    object PersonCanSpeak extends CanSpeak[Person] {
      override def say(x: Person): String = s"Hello my name is ${x.name}"
    }

    def speak[A](a: A, canSpeak: CanSpeak[A]) = println(canSpeak.say(a))
  }

  //Using implicits
  object SecondVariant {

    //    def speak[A](a: A)(implicit canSpeak: CanSpeak[A]) = canSpeak.say(a)

    //The same as above using syntax sugar
    def speak[A:CanSpeak](a: A) = println(implicitly[CanSpeak[A]].say(a))
  }

  //Using companion object
  object ThirdVariant {
    def speak[A:CanSpeak](a: A) = println(CanSpeak[A].say(a))
  }

  //Using implicits class
  object FourthVariant {

    implicit class CanSpeakOps[A:CanSpeak](a: A) {
      def speak() = println(CanSpeak[A].say(a))
    }
  }


}
