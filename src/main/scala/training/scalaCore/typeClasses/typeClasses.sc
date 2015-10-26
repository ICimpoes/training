import training.scalaCore.typeClasses.Statistics

val numbers = Vector[Double](13, 23.0, 42, 45, 61, 73, 96, 100, 199, 420, 900, 3839)
Statistics.mean(numbers)

val strings = Vector[String]("1", "2")
Statistics.mean(strings)
