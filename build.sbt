name := "training"

version := "1.0"

scalaVersion := "2.11.7"

unmanagedSourceDirectories in Compile := List((scalaSource in Compile).value)

unmanagedSourceDirectories in Test := List((scalaSource in Test).value)

val catsVersion = "0.2.0"
val catsAll = "org.spire-math" %% "cats" % catsVersion

val scalaTestVersion = "2.2.4"
val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies ++= Seq(
  catsAll,
  scalaTest
)
