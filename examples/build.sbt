name := "Scala.js Examples"

version := "0.1-SNAPSHOT"

lazy val root = project.in(file("."))
    .aggregate(email, testing)

lazy val email = project.in(file("email"))
    .settings(scalaJSSettings: _*)

lazy val testing = project.in(file("testing"))
    .settings(scalaJSSettings: _*)
