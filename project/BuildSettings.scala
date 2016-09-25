import sbt.Keys._

object BuildSettings {

  lazy val projectVersion = "1.0"

  lazy val commonSettings = Seq(
    version := projectVersion,
    scalaVersion := "2.11.7",
    fork in run := true
  )

  lazy val scalaTrainingSettings = commonSettings ++
    Seq(name := "scala-core-training")

  lazy val puzzlesSettings = commonSettings ++
    Seq(name := "puzzles")

  lazy val catsTrainingSettings = commonSettings ++
    Seq(name := "cats-training")

  lazy val typeClassesSettings = commonSettings ++
    Seq(name := "type-classes")

}
