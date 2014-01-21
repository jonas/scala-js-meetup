name := "Scala.js Examples"

version := "0.1-SNAPSHOT"

lazy val root = project.in(file("."))
    .aggregate(
        `untyped-email`,
	testing
    )

lazy val `untyped-email` = project.in(file("untyped-email"))
    .settings(scalaJSSettings: _*)
    .settings(
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val testing = project.in(file("testing"))
    .settings(scalaJSSettings: _*)
