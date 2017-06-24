

lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  organization := "com.github.komsit37",
  scalaVersion := "2.12.2"
)

lazy val versions = new {
  val h2 = "1.4.192"
  val logback = "1.2.3"
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
      "ch.qos.logback" % "logback-classic" % versions.logback,
      "com.h2database" % "h2" % versions.h2,
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
    unmanagedSourceDirectories in Compile += target.value / "java" / "src_unmanaged" / "main",
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % versions.logback,
      "com.h2database" % "h2" % versions.h2,
      "com.goldmansachs.reladomo" % "reladomo" % versions.reladomo,
      "com.goldmansachs.reladomo" % "reladomo-test-util" % versions.reladomo % "test",

      "org.scalatest" %% "scalatest" % versions.scalatest % "test"
    )
  )
  .dependsOn(`reladomo-gen`)