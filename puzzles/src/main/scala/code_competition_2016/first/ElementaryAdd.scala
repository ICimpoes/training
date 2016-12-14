package code_competition_2016.first

/**
  * Problem 1: ELEMENTARY ADDITIONS
  *
  * The non-negative integers are represented by the following sets:
  *
  * 0 is represented by the empty set {}.
  * For any number n > 0, n is represented by a set containing the representations of all non-negative integers smaller than n.
  * For example, the first 4 non-negative integers are represented by:
  *
  * 0 => {}
  * 1 => {{}}
  * 2 => {{},{{}}}
  * 3 => {{},{{}},{{},{{}}}}
  *
  * and so on. Notice that the cardinality (size) of the set is exactly the integer it represents.
  * Although the elements of a set are generally unordered, although we require that the elements of a set to be ordered in increasing cardinality to make the assignments easier to grade.
  *
  * INPUT
  * The first line of the input contains a positive integer giving the number of cases to follow.
  * For each case, there are two lines of input each containing a non-negative integer represented in set notation.
  * Each line contains only the characters ‘{‘, ‘}’, and ‘,’. The sum of the two given integers will be at most 15.
  *
  * OUTPUT
  * For each test case, output the sum of the two input integers in the set notation described above.
  *
  * SAMPLE INPUT
  * 3
  * {}
  * {}
  * {{}}
  * {{},{{}}}
  * {{},{{}},{{},{{}}}}
  * {{}}
  *
  * SAMPLE OUTPUT
  * {}
  * {{},{{}},{{},{{}}}}
  * {{},{{}},{{},{{}}},{{},{{}},{{},{{}}}}}
  *
  *
  *
  */
object ElementaryAdd {

  private val startIntToSet = Map(0 -> "{}", 1 -> "{{}}")
  private val startSetToInt = Map("{}" -> 0, "{{}}" -> 1)

  //generate dictionary
  private val (_, intToSet, setToInt) = Range(2, 16)
    .foldLeft((List("{}", "{{}}"), startIntToSet, startSetToInt)) {
      case ((l, i2S, s2I), i) =>
        val set = s"{${l.mkString(",")}}"
        (l.:+(set), i2S.+(i -> set), s2I.+(set -> i))
    }

  def apply(f: String, s: String): String = {
    intToSet(setToInt(f) + setToInt(s))
  }

}
