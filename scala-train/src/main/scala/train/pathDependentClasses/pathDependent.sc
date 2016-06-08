case class Franchise(name: String) {

  case class Character(name: String)

  def createFanFictionWith(lovestruck: Character, objectOfDesire: Character) =
    lovestruck -> objectOfDesire
}

val starTrek = new Franchise("Star Trek")
val starWars = new Franchise("Star Wars")

val quark = starTrek.Character("Quark")
val jadzia = starTrek.Character("Jadzia Dax")

val luke = starWars.Character("Luke Skywalker")
val yoda = starWars.Character("Yoda")

//starTrek.createFanFictionWith(quark, luke) -- does not compile
starTrek.createFanFictionWith(quark, jadzia)
starWars.createFanFictionWith(luke, yoda)
