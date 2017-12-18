name := "ScalaSignInService"

version := "0.1"

scalaVersion := "2.12.4"


libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.2.0"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.postgresql" % "postgresql" % "9.4.1212"

)