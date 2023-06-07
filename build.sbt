name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.11"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
    "ch.qos.logback" % "logback-classic" % "1.4.7",
    "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )
}
