import sbt.Keys._
import sbt._
import uk.gov.hmrc.versioning.SbtGitVersioning

object HmrcBuild extends Build {

  import uk.gov.hmrc.DefaultBuildSettings._
  import uk.gov.hmrc.SbtAutoBuildPlugin

  val appName = "stream-processor"

  lazy val streamProcessor = Project(appName, file("."))
    .enablePlugins(SbtAutoBuildPlugin, SbtGitVersioning)
    .settings(
      targetJvm := "jvm-1.7",
      scalaVersion := "2.11.7",
      libraryDependencies ++= AppDependencies(),
      resolvers := Seq(
        "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases/",
        Resolver.bintrayRepo("hmrc", "releases")
      ),
      crossScalaVersions := Seq("2.11.7"),
      ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
    )
}

private object AppDependencies {

  val compile = Seq(
  )

  trait TestDependencies {
    lazy val scope: String = "test"
    lazy val test : Seq[ModuleID] = ???
  }

  object Test {
    def apply() = new TestDependencies {
      override lazy val test = Seq(
        "org.scalatest" %% "scalatest" % "2.2.4" % scope,
        "org.pegdown" % "pegdown" % "1.4.2" % scope
      )
    }.test
  }

  def apply() = compile ++ Test()
}
