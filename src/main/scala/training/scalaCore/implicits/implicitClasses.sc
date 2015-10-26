import training.scalaCore.implicits.ICanSayHello
import training.scalaCore.implicits.SomeObject._

ICanSayHello("a").hello("Name")
//this is called from implicit class
ICanSayHello("a").goodbye