import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.functions
import org.apache.spark.sql.functions._





object first_scala_spark {
  def main(args: Array[String]): Unit = {

    val spark:SparkSession = SparkSession.builder().master("local").appName("testing").getOrCreate()
    val spark1=spark.read.format("csv").option("header","true").load("D://movies//test.csv")
    spark1.show()
    val spark2=spark.read.format("csv").option("header","true").load("D://movies//incre.csv")
    spark2.show()
    val s3=spark1.join(spark2,spark1("id")===spark2("id"),"leftsemi")
    s3.show()
    println("semi")
    val s4=spark1.join(spark2,spark1("id")===spark2("id"),"leftanti")
    println("anti")
    s4.show()
    val s="how are you big small hows arent are you big "
    val s2=s.split(" ").map(_.tail).map(x=>(x,1))
    s2.foreach(println)
    val spark5 = spark.read.format("csv").option("header", "true").load("D://movies//null_check.csv")
    spark5.show()
    val cols = spark5.columns.filter(_.startsWith("col")).map(col(_))
    println("array_prijnt")
    cols.foreach(println)
    //val s6=spark5.select("id",coalesce(cols:_ *).as("logic"))
    val sq=Seq(("00EEE","00EEE FFF","DRINK"),("000EEE","00EEE FFF","Fruit"),("0EEE","000EEE FFF","Fruit"))
    //val s7=sq.toDF("sub_cat","sub_cat_label")
    //s7.show()
    //val null_c=spark5.select($"id")
    //coalesce($"col_1",$"col_2",$"col_3").as("f"))
    //null_c.show()

   /* val l=List("hi","ravi")
    val l1=l.map(s => s.head)
    println(l1)
    val str = "hello world"
    val words = str.split(" ")
    var reversed = ""
    for (i <- words.length - 1 to 0 by -1) {

      reversed += words(i) + " "
      println(reversed)
    }
    reversed = reversed.trim
    println(reversed) // prints "world hello"
    val x = List(1, 40, 10)
    val y = List(20, 25, 30)
    val z = List("DataCamp", "Tutorials", "Are", "The", "Best")
    println("Is list x, y, z empty? = " + (x.isEmpty, y.isEmpty, z.isEmpty));

    println("Head of list x, y, z = " + (x.head, y.head, z.head));


    //Tail
    println("Tail of list x, y, z = " + (x.tail, y.tail, z.tail));


    //Concatenate
    println("Concatenating x, y, z lists with the first method = " + (x:::y:::z));
    println("Concatenating x, y, z lists with the second method = " + ((x).:::(y).:::(z)));
    println("Concatenating x, y, z lists with the third method = " + (List.concat(x,y,z)));
    println();

    //Reverse
    println("Reverse of x, y, z is = " + (x.reverse, y.reverse, z.reverse));


    //Fill
    println("Output of Fill method is = " + (List.fill(5)(z)));


    //Tabulate
    println("Output of Tabulate method is = " + (List.tabulate(5)(x => x * x * x)));




    //val s4=s3.saveAsTextFile("C:\\Users\\91949\\OneDrive\\Desktop\\test_spark_word_op.txt")
    def add(x:Int)(y:Int)=x+y
    val a=add(10) _
    val a1=a(20)
    val langs=Seq(("j",2,true),("s",7,false),("p",3,false),("g",4,true))


    def nums_++(num:List[_]):List[_]=List.concat(num,num,"hello")

    def div(x:Int,y:Int):Option[Int]={
      if (y!=0) scala.Some(x/y)
      else None
    }

    //val langs: Seq[String] =Seq("Java", "Python", "Scala")
    //val AllLang: (String, String) => String = (a, b) => a+b+ "Lang,"
    //  println(s"All Langs= ${langs.foldLeft("my")(AllLang)}")
    println(div(100,0))
    println(a1)
    val chr="hi syamala rao"
    val spli=chr.split(" ").reverse.mkString(" ")
    println(spli)
    val s33=Map(1->"syam",2->"ravi")
    println(s33.get(1))
    def isBalanced(input: String): Boolean = {
      val stack = scala.collection.mutable.Stack[Char]()
      for (char <- input) {
        if (char == '(' || char == '[' || char == '{') {
          stack.push(char)
        } else if (char == ')' && stack.nonEmpty && stack.top == '(' ||
          char == ']' && stack.nonEmpty && stack.top == '[' ||
          char == '}' && stack.nonEmpty && stack.top == '{') {
          stack.pop()
        } else {
          return false
        }
      }
      stack.isEmpty
    }

    println(isBalanced("[()]"))

   val object_test=new Test_sdga()
    val list1=List(10,20,30)
   val l_sum= list1.reduceLeft(_ max _)
    val l_sum1= list1.foldLeft(0)(_+_)
    println(s"$l_sum is reduce $l_sum1 is fold ")
   val str=Array("hi","ram")
    str.foreach(println)
    def sum_t(a:List[Int]):Int={
      var cou=0
      for (i <- a ) yield (i)
      //var cou =cou + i
      //println(i)
    }*/
   val object_test=new Test_sdga()
    val sample=spark.read.format("jdbc").option("driver","oracle.jdbc.driver.OracleDriver")
      .option("url","jdbc:oracle:thin:@192.168.29.184:1521:ORCL")
      .option("user","SYSTEM")
      .option("password","sURYA958@")
      //.option("dbtable","s_db.student]").load()
      .option("query","select count(*) from student").load()
    println(sample.count())
    println("hhhhhh")

  }
}
