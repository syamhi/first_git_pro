name := "Demospark"

version := "0.1"

scalaVersion := "2.12.16"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.3.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.3.0" % "provided"
// https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc
libraryDependencies += "com.microsoft.sqlserver" % "mssql-jdbc" % "9.4.1.jre8"
// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-hdfs
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "3.1.3" % Test

// https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8
libraryDependencies += "com.oracle.database.jdbc" % "ojdbc8" % "21.1.0.0"


