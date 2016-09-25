import BuildSettings._
import Dependencies._

lazy val settings =
  shellPrompt := { s => Project.extract(s).currentProject.id + " > " }

lazy val root = project.in(file("."))
  .aggregate(scalaCore, catsTraining, puzzles, typeClasses)
  .settings(commonSettings: _*)

lazy val scalaCore = project.in(file("scala-train"))
  .settings(scalaTrainingSettings: _*)
  .settings(libraryDependencies ++= scalaTest)

lazy val puzzles = project.in(file("puzzles"))
  .settings(puzzlesSettings: _*)
  .settings(libraryDependencies ++= scalaTest)

lazy val catsTraining = project.in(file("cats-train"))
  .settings(catsTrainingSettings: _*)
  .settings(libraryDependencies ++= scalaTest :+ catsAll)

lazy val typeClasses = project.in(file("type-classes"))
  .settings(typeClassesSettings: _*)
  .settings(libraryDependencies ++= scalaTest)
