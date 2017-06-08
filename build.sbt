

lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  organization := "com.github.komsit37",
  scalaVersion := "2.12.2"
)

lazy val versions = new {
  val ant = "1.10.1"
  val reladomo = "16.1.3"
  val scalatest = "3.0.1"
}

// must be cross compiled with scala 2.10 because sbt-plugin has a dependency on this.
lazy val reladomogen = (project in file("reladomogen"))
.settings(commonSettings)
.settings(
  name := "reladomogen",
  unmanagedSourceDirectories in Test += target.value / "java" / "src_unmanaged" / "test",
  libraryDependencies ++= Seq(
    "org.apache.ant" % "ant" % versions.ant,
    "com.goldmansachs.reladomo" % "reladomogen" % versions.reladomo,
    "com.goldmansachs.reladomo" % "reladomo-gen-util" % versions.reladomo,
    "com.goldmansachs.reladomo" % "reladomo" % versions.reladomo,
    "org.scalatest" %% "scalatest" % versions.scalatest % "test"
  )
)