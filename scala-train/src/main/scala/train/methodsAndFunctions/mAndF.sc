object SomeFilters {
  def isPositive(x: Int): Boolean = x > 0
}

val filter = (predicate: Int => Boolean, xs: List[Int]) => {
  for (x <- xs; if predicate(x)) yield x
}

val positiveNums = filter(SomeFilters.isPositive, List(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))