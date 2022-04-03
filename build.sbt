name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.8"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "2.0.1",
    "ch.qos.logback" % "logback-classic" % "1.2.11",
    "org.scalatest" %% "scalatest" % "3.2.11" % Test
  )
}
