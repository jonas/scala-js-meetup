name := "Scala.js Examples"

version := "0.1-SNAPSHOT"

lazy val root = project.in(file("."))
    .aggregate(
        `js-api`,
        `js-dynamic`,
        `jquery-wrapper`,
        `dom-wrapper`,
        `untyped-email`,
        `dom-email`,
        `jquery-email`,
	testing
    )

lazy val `js-api` = project.in(file("js-api"))
    .settings(scalaJSSettings: _*)
    .settings(
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val `js-dynamic` = project.in(file("js-dynamic"))
    .settings(scalaJSSettings: _*)
    .settings(
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val `jquery-wrapper` = project.in(file("jquery-wrapper"))
    .settings(scalaJSSettings: _*)
    .settings(
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val `dom-wrapper` = project.in(file("dom-wrapper"))
    .settings(scalaJSSettings: _*)
    .settings(
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
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

lazy val `jquery-email` = project.in(file("jquery-email"))
    .settings(scalaJSSettings: _*)
    .settings(
        libraryDependencies += "org.scala-lang.modules.scalajs" %% "scalajs-dom" % "0.1-SNAPSHOT",
        libraryDependencies += "org.scala-lang.modules.scalajs" %% "scalajs-jquery" % "0.1-SNAPSHOT",
        unmanagedSources in (Compile, ScalaJSKeys.packageJS) +=
            baseDirectory.value / "js" / "startup.js"
    )

lazy val testing = project.in(file("testing"))
    .settings(scalaJSSettings: _*)
