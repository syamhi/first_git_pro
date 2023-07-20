import org.apache.spark.sql.SparkSession

object dataframe_test {
  def main(args: Array[String]): Unit = {
    val spark:SparkSession = SparkSession.builder().master("local").appName("testing").getOrCreate()
  /* val s1=spark.read.format("jdbc").option("driver","com.microsoft.sqlserver.jdbc.SQLServerDriver")
      .option("url","jdbc:sqlserver:{//DESKTOP-6410GIV};databaseName={master}")
      .option("user","syamtest")
      .option("password","sURYA958@")
      .option("dbtable","[dbo].[call_end_logs]").load() */
    val s1=spark.read.format("jdbc").option("driver","oracle.jdbc.driver.OracleDriver")
      .option("url","jdbc:oracle:thin:@192.168.29.184:1521:ORCL")
      .option("user","SYSTEM")
      .option("password","sURYA958@")
      .option("dbtable","[dbo].[s_db].student").load()
    println(s1.count())
   // sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:oracle:thin:@192.168.41.93:1521:ORCL", "user" -> "ILABUSER",
    //  "password" -> "impetus", "dbtable" -> Query, "driver" -> "oracle.jdbc.driver.OracleDriver")).load()

    println("hi")

  }
}
