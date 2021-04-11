name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.5"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" %% "scalatest" % "3.2.7" % Test
  )
}
