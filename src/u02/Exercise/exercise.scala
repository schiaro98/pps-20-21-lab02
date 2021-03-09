package u02.Exercise

object exercise extends App {

  //Check for parity
  def parity(n: Int): String = n match {
    case n if n % 2 == 0 => "Even"
    case _ => "Odd"
  }

  def neg(f: String => Boolean): String => Boolean = !f(_)

  val parity2: Int => String = {
    case n if n % 2 == 0 => "even"
    case _ => "odd"
  }

  val neg2: (String => Boolean) => String => Boolean = f => s => !f(s)
  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty: String => Boolean = neg2(empty) // which type of notEmpty?

  //Currying
  val p1:(Int, Int, Int) => Boolean = (x,y,z) => x <= y && y <= z
  val p2: Int => Int => Int => Boolean = x => y => z => x <= y && y <= z

  def p3(x:Int, y:Int, z:Int): Boolean = x <= y && y<=z
  def p4(x:Int)(y:Int)(z:Int): Boolean = x <= y && y<=z

}
