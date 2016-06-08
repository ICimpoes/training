package train

package object implicits {

  case class ICanSayHello(a: String) {
    def hello(name: String) = s"Hello $name, I'm $a"
  }

  object SomeObject {
    //implicit class must be inside an object/class/trait
    implicit class ICanSayHelloAndGoodBy(a: ICanSayHello) {
      def goodbye = "Good by!"
    }
  }
}
