import sbt._

object Dependencies {
  val dockerTestkitScalatest = "com.whisk" %% "docker-testkit-scalatest" % "0.9.5"
  val dockerTestkitImpl = "com.whisk" %% "docker-testkit-impl-spotify" % "0.9.5"

  val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % "2.5.13"
}
