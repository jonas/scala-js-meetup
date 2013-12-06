name := "play-quiz-presenter-app"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  "org.webjars" %% "webjars-play" % "2.2.1",
  "org.webjars" % "bootstrap" % "3.0.3"
)

play.Project.playScalaSettings

//libraryDependencies += "com.tristanhunt" % "knockoff" % "0.8.2"
