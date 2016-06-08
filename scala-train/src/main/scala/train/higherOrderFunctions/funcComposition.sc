val values: List[Int] = List(1, 2, 3, 4, 5)

val functions: List[Int => Int] = List(_ + 1, _ * 2, x => x * x)

def compose1[T](values: List[T], functions: List[T => T]) = values map ( functions reduce(_ andThen _))
// ==
def compose2[T](values: List[T], functions: List[T => T]) = values map functions.reverse.reduce(_ compose _)

compose1(values, functions)
compose2(values, functions)