object iqvia_test extends App {



  val sa="hello world"

  def reverses(sa:String):String=
    (for(i <- sa.length - 1 to 0 by -1) yield sa(i)).mkString

  println(reverses("hello world"))
  println(sa.count(_ == "e"))
  println("hello world".count(_ == 'o'))
  val s = "abc"

  // Generate all possible substrings of the input string
  val substrings = for {
    i <- 0 until s.length
    j <- i + 1 to s.length
  } yield s.substring(i, j)
  println(substrings)
  // Generate all possible permutations of each substring and flatten the result
  val output = substrings.flatMap(substring => substring.permutations.toList)
  //val output :List[String]=substrings.flatMap(substring => substring.permutations)
  val l:List[Int] =List(1,20,500)
  println(l.reverse)
  val sit=List(1,58,86)
  val sir2=List(2,8,4)
  def factorial(n: Int): Int = {
  {
    if (n == 0)
      return 1
    else
      return n * factorial(n-1)
  }
  }
  val sdd=sir2.map(x=>factorial(x))
  println(sdd)

  val s5=(sit zip sir2).toMap
  println(s"hi this zip $s5")
  println(s"hi this  ${s5}")

  // Print the output
  println(output)
  /*object iqvia_test1 {
    def add(a: Int, b: Int) = a + b

    val s2 = iqvia_test1.add(2,3)
    println(s2)*/
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.HashMap[Int, Int]()

    for (i <- nums.indices) {
      println(s"$i i is")
      val complement = target - nums(i)
      println(s"$complement comp")
      if (map.contains(complement)) {
        return Array(map(complement), i)
      }
      map(nums(i)) = i

    }
    throw new IllegalArgumentException("No two sum solution")
  }
  val nums = Array(2,7,11,15)
  val target = 22
  val result = twoSum(nums, target)
  println(result.mkString("[", ",", "]"))
  def scalaProgram
  {
    println("Welcome to InterviewBit")
  }
  scalaProgram
  val employee= Map("InterviewBit" -> "Aarav", "Scaler" -> "Ankesh")
  val a= employee.get("InterviewBit")
  val b= employee.get("Informatica")
  println(a);
  println(b);
  trait MyCompany
  {
    def company
    def position
  }
  class MyClass extends MyCompany
  {
    def company()
    {
      println("Company: InterviewBit")
    }
    def position()
    {
      println("Position: SoftwareDeveloper")
    }
    def employee()                  //Implementation of class method
    {
      println("Employee: Aarav")
    }
  }
  object Main
  {
    def main(args: Array[String])
    {
      val obj = new MyClass();
      obj.company();
      obj.position();
      obj.employee();

    }
  }

  val s14 = Seq("apple", "oranges", "apple", "banana", "apple", "oranges", "oranges")
  val s15=s14.groupBy(l => l).map(t => (t._1, t._2.length))
  println(s15)
}

