ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "scala-backend-challange"
  )


val scalatestVersion = "3.2.15"
val fs2Version = "3.6.1"

libraryDependencies ++= Seq(
    // Testing
    "org.scalatest" %% "scalatest" % scalatestVersion,

    //fs2
    "co.fs2" %% "fs2-core" % fs2Version,
    "co.fs2" %% "fs2-io" % "3.6.1"
)