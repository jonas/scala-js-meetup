name := "Scala.js Examples"

version := "0.1-SNAPSHOT"

lazy val root = project.in(file("."))
    .aggregate(
        `untyped-email`,
        `dom-email`,
	testing
    )

lazy val `untyped-email` = project.in(file("untyped-email"))
    .settings(scalaJSSettings: _*)
    .settings(
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val `dom-email` = project.in(file("dom-email"))
    .settings(scalaJSSettings: _*)
    .settings(
        libraryDependencies += "org.scala-lang.modules.scalajs" %% "scalajs-dom" % "0.1-SNAPSHOT",
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val testing = project.in(file("testing"))
    .settings(scalaJSSettings: _*)
