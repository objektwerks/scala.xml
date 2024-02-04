name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.4.0-RC4"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "2.2.0",
    "ch.qos.logback" % "logback-classic" % "1.4.14",
    "org.scalatest" %% "scalatest" % "3.2.17" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
