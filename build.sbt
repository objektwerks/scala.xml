name := "scala.xml"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.6"
libraryDependencies ++= {
  Seq(
    "org.scala-lang.modules" %% "scala-xml" % "1.1.0",
    "org.json4s" %% "json4s-core" % "3.5.3",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
  )
}
scalacOptions ++= Seq(
  "-language:postfixOps",
  "-language:reflectiveCalls",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-feature",
  "-Ywarn-unused-import",
  "-Ywarn-unused",
  "-Ywarn-dead-code",
  "-unchecked",
  "-deprecation",
  "-Xfatal-warnings",
  "-Xlint:missing-interpolator",
  "-Xlint"
)
fork in test := true
javaOptions += "-server -Xss1m -Xmx2g"