trait A {
  def a(s : String) : String
}

trait TimingA extends A {
  abstract override def a(s : String) = {
    val start = System.currentTimeMillis
    println("In TimingA")
    val result = super.a(s)
    val dur = System.currentTimeMillis-start
    println("Executed a in %s ms".format(dur))
    result
  }
}
trait ParameterPrintingA extends A {
  abstract override def a(s : String) = {
    println("Called a with s=%s".format(s))
    super.a(s)
  }
}
trait ImplementingA extends A {
  def a(s: String) = {
    Thread.sleep(1000)
    s.reverse
  }
}
//ParameterPrintingA -> TimingA -> ImplementingA
val a = new ImplementingA with TimingA with ParameterPrintingA
//TimingA -> ParameterPrintingA -> ImplementingA
val b = new ImplementingA with ParameterPrintingA with TimingA
val c = new ImplementingA{}
a.a("Hello!")
"---------------------------"
b.a("Hello!")
"---------------------------"
c.a("Hello!")
"---------------------------"