name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.7.2-RC1"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
    "ch.qos.logback" % "logback-classic" % "1.5.18",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
