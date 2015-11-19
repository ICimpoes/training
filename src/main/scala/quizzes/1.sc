def unless(condition: Boolean)(block: => Unit) = {
  if (condition) block
}

val unless2: Boolean => Unit = if (_: Boolean) _: Unit

var x = 2
unless2(x > 0) {
  x = x + 1
}
x

