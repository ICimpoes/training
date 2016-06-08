import train.implicits.ICanSayHello
import train.implicits.SomeObject._

ICanSayHello("a").hello("Name")
//this is called from implicit class
ICanSayHello("a").goodbye