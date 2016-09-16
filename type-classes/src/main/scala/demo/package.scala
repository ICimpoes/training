import java.util.Comparator

package object demo {

  def max_old[T <: Comparable[T]](x: T, y: T) = {
    if (x.compareTo(y) >= 0) x else y
  }




  def max[T](x: T, y: T)(implicit ev: Comparator[T]) = {
    if (ev.compare(x, y) >= 0) x else y
  }

  def max2[T](x: T, y: T)(compare: (T, T) => Int) = {
    if (compare(x, y) >= 0) x else y
  }



}
