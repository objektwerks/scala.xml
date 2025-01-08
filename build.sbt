name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.6.3-RC2"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
    "ch.qos.logback" % "logback-classic" % "1.5.16",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
