package u02.Exercise

sealed trait Shape
object Shape {
  case class Rectangle(base: Int, height: Int) extends Shape
  case class Circle(radius: Int) extends Shape
  case class Square(size: Int) extends Shape

  def area(s: Shape): Double = s match {
    case Rectangle(b,h) => b * h
    case Square(b) => b * b
    case Circle(r) => r*r*Math.PI
    //case _ => ??? Unnecessary, Trait is sealed
  }

  def perimeter(s: Shape): Double = s match {
    case Rectangle(b,h) => b*2 + h*2
    case Square(b) => b * 4
    case Circle(r) => r*2*Math.PI
    //case _ => ??? Unnecessary, Trait is sealed
  }
}
