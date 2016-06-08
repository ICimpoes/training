def unless(condition: Boolean)(block: => Unit) = {
  if (!condition) block
}

