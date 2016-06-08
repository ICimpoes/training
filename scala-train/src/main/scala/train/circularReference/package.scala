package train

package object circularReference {

  /**
   * One object is free to point itself at the other without requiring that the other one has been initialized already.
   *
   * Example:
   * {{{
   *   lazy val p1: PairedObject = new PairedObject(p2, "P1")
   *   lazy val p2: PairedObject = new PairedObject(p1, "P2")
   * }}}
   */
  class PairedObject(p: => PairedObject, val id: String) {
    lazy val partner: PairedObject = p
  }

  object ChickenOrEgg {
    class Chicken(e: => Egg) {
      lazy val offspring = e
    }
    class Egg(c: => Chicken) {
      lazy val mother = c
    }
  }
}
