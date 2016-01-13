class A {
  class B {
    val a: String = "aa"
  }
}
val a: A = new A
val b: A#B = new a.B