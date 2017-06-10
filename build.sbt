

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
lazy val `reladomo-gen` = (project in file("reladomo-gen"))
.settings(commonSettings)
.settings(
  name := "reladomo-gen",
  unmanagedSourceDirectories in Compile += target.value / "java" / "src_unmanaged" / "main",
  libraryDependencies ++= Seq(
    "org.apache.ant" % "ant" % versions.ant,
    "com.goldmansachs.reladomo" % "reladomogen" % versions.reladomo,
    "com.goldmansachs.reladomo" % "reladomo-gen-util" % versions.reladomo,
    "org.scalatest" %% "scalatest" % versions.scalatest % "test"
  )
)

lazy val `reladomo-sample` = (project in file("reladomo-sample"))
  .settings(commonSettings)
  .settings(
    name := "reladomo-sample",
    libraryDependencies ++= Seq(
      "com.goldmansachs.reladomo" % "reladomo" % versions.reladomo,
      "org.scalatest" %% "scalatest" % versions.scalatest % "test"
    )
  )