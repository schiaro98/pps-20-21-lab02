package u02.Exercise

object Recursion extends App {

  def fibonacci(n: Int): Int = n match {
    case n if n < 0 => 0 ; //ArithmeticException
    case 0|1 => n
    case _ => fibonacci(n - 1) + fibonacci(n - 2)
  }
}
