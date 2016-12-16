package code_competition_2016.second

object CryptoColumns {

  @inline
  def apply(key: String, text: String): String = {

    val map = key.zipWithIndex.sorted.map(_._2).zipWithIndex.toMap

    val slide = text.length / key.length

    val columns = text.sliding(slide, slide).toVector

    @inline
    def append(s: String, x: Int, y: Int): String = s + columns(map(y))(x)

    (for {
      x <- Range(0, slide)
      y <- Range(0, key.length)
    } yield x -> y).foldLeft("") { case (s, (x, y)) =>
      append(s, x, y)
    }
  }
}