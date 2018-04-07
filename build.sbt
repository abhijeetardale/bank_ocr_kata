name := """bank_ocr_kata"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

val mongoVersion="0.11.14"

libraryDependencies += ws

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % mongoVersion,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.mockito" % "mockito-all" % "1.10.19" % Test,
  "org.mockito" % "mockito-core" % "1.9.5" % Test,
  "org.scalatest" % "scalatest_2.11" % "2.2.6" % Test
)


