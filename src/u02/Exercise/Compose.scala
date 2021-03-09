package u02.Exercise

object Compose extends App {
  def compose(f: Int => Int, g: Int => Int) : Int => Int = { x => f(g(x))}

  def composeGeneral[A,B,C](f: B => C, g: A => B): A => C = {
    x => f(g(x))
  }
}
