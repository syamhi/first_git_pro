import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, dense_rank, input_file_name, row_number}
import org.apache.spark.sql.{DataFrame, SparkSession}

class Test_sdga {
  val spark:SparkSession = SparkSession.builder().master("local").appName("testing").getOrCreate()
  val spark1=spark.read.format("csv").option("header","true").option("inferSchema","true").load("D://movies//test.csv")
  spark1.show()
  //val s2=spark1.na.fill("wrong")
  //s2.show()

  val sl1=spark1.select(col("id"),col("name"),col("mgr_id"),col("salary"))
  sl1.show()
  sl1.printSchema()
  //val spark2=spark.read.format("csv").option("header","true").option("recursiveFileLookup","true").load("D://movies//test_output.csv/").withColumn ("file_name",input_file_name())
  //spark2.show()
  println("recur")
  val sl2=sl1.filter(col("name")==="ravi").show()
 // "D:\movies\test_output.csv"
  val win=Window.partitionBy("id").orderBy(col("salary").desc)
  val sl3=sl1.withColumn("ran",dense_rank() over(win))
  sl3.show()
  val sl3_row=sl1.withColumn("ran",row_number() over(win))
  val sl4=sl3_row.filter(col("ran")===1)
  sl4.show()
  val sl5=sl4.as("emp").join(sl1.as("mgr"),col("emp.mgr_id")===col("mgr.id"),"left").select(col("emp.id").as("emp_name"),col("mgr.mgr_id").as("mgr_id"),col("emp.salary"),col("mgr.name"),col("emp.name").as("emp_name")).filter(col("emp.salary")>col("mgr.salary")).show()
    //join(sl1.as("mgr"),$"emp.id"==$"mgr.mgr_id","left")
    //.select($"emp.id",$"mgr.mgr_id",col("salary")).show()
  println("wins")
  /*def colum(df1:DataFrame,df2:DataFrame):List[String]={
   val s_c= df1.columns.toList
   val s_c1= df2.columns.toList
   val sc_3=s_c1.intersect(s_c)
    val sc_4=s_c1.diff(s_c)


    return sc_4
  }
  val s3=colum(spark1,spark2)
  println(s3)*/
 // s2.write.format("parquet").option("header","true").save("D://movies//test_output1.parquet")
  /* val s1=spark.read.format("jdbc").option("driver","com.microsoft.sqlserver.jdbc.SQLServerDriver")
    .option("url","jdbc:sqlserver://192.168.1.185:1433;instanceName=SQLSERVER;databaseName=master;useNTLMV2=true")
    .option("user","syamtest")
    .option("password","sURYA958@")
    .option("dbtable","[dbo].[call_end_logs]").load()
  println("class working fine") */

}
