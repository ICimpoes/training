package training.scalaCore.sort

import scala.annotation.tailrec
import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

object SortApp extends App {

  def mergeSort(list: List[Int]): List[Int] = {

    def mergeSortedLists(sortedList1: List[Int], sortedList2: List[Int]) = {

      @tailrec
      def accMerg(s1: List[Int], s2: List[Int], acc: List[Int]): List[Int] = {
        if (s1.isEmpty)
          acc ::: s2
        else {
          val (h :: t) = s1
          val (s21, s22) = s2.partition(_ <= h)
          val temp = acc ::: s21.:+(h)
          accMerg(t, s22, temp)
        }
      }

      accMerg(sortedList1, sortedList2, Nil)
    }

    val length = list.length
    if (length <= 1) {
      list
    } else {
      val (l1, l2) = list.splitAt(length / 2)
    }

    list match {
      case Nil => Nil
      case l@(head :: Nil) => l
      case head :: tail =>
    }



    list

  }

}