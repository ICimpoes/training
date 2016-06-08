package train
//
//import scala.annotation.tailrec
//
package object sort {
//
//  /**
//   * quick sort implementation
//   */
//  def quickSort(list: List[Int]): List[Int] = {
//    if (list.length <= 1) {
//      list
//    } else {
//      val (head :: tail) = list
//      quickSort(tail.filter(_ <= head)) ::: head :: quickSort(tail.filter(_ > head))
//    }
//  }
//
//  /**
//   * quick sort implementation
//   */
//  @tailrec
//  def quickSortTailRec(list: List[Int]): List[Int] = {
//
//    def temp(l1: List[Int], acc: List[Int]): List[Int] = {
//      if (list.length <= 1) {
//        acc
//      } else {
//        val (head :: tail) = list
//
////        quickSort(tail.filter(_ <= head)) ::: head :: quickSort(tail.filter(_ > head))
//      }
//    }
//
//    temp(list, Nil)
//  }
//
}
