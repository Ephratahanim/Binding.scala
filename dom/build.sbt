enablePlugins(ScalaJSPlugin)

organization := "com.thoughtworks.binding"

name := "dom"

description := "Reactive web framework for Scala.js."

libraryDependencies += "com.thoughtworks.extractor" %% "extractor" % "1.0.2"

libraryDependencies += "com.lihaoyi" %%% "scalatags" % "0.6.0"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

jsDependencies += RuntimeDOM

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.0" % Test

resolvers in ThisBuild += Resolver.sonatypeRepo("releases")

libraryDependencies += "org.typelevel" %% "macro-compat" % "1.1.1"

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value % Provided

libraryDependencies ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.6")
    case _ =>
      Nil
  }
}

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

releasePublishArtifactsAction <<= PgpKeys.publishSigned

scalacOptions += "-Xexperimental"
