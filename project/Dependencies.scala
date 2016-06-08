import sbt.{Keys => _, _}

object Dependencies {

  def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

  def test(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  val catsVersion = "0.2.0"
  val catsAll = "org.spire-math" %% "cats" % catsVersion

  val scalaTestVersion = "2.2.4"
  val scalaTest = test("org.scalatest" %% "scalatest" % scalaTestVersion)

}
