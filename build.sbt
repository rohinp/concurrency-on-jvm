lazy val root = project
  .in(file("."))
  .settings(
    name := "concurrency-on-jvm",
    description := "Concurrency on jvm, examples done in scala 3",
    version := "0.1.0",
    scalaVersion := "3.0.0-M3",
    useScala3doc := true
  )
libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.1" withSources()
