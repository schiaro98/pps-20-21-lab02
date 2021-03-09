package u02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.{Disabled, Test}
import u02.Exercise.{Compose, Shape}
import u02.Exercise.Recursion.fibonacci
import u02.Exercise.Shape._
import u02.Exercise.exercise._

class TestExercise {

   @Test def testParity() {
    assertEquals("Even",parity(4))
    assertEquals("Odd",parity(3))
  }

  @Disabled def negFunc(){
    //assertTrue(notEmpty("foo"))
    //assertTrue(notEmpty("foo") && !notEmpty("") )
    //assertFalse(notEmpty(""))
  }

  @Test def testFibonacci(): Unit ={
    assertEquals(fibonacci(0), 0)
    assertEquals(fibonacci(1), 1)
    assertEquals(fibonacci(2), 1)
    assertEquals(fibonacci(3),2)
    assertEquals(fibonacci(4),3)
    assertEquals(fibonacci(5),5)
    assertEquals(fibonacci(6),8)
  }

  @Test def testCurrying(): Unit ={
    //assertTrue(Currying.p1(1,2,3))
    //assertTrue(Currying.p2(1)(2)(3))
    assertTrue(p3(1,2,3))
    assertTrue(p4(1)(2)(3))
  }

  @Test def composition(): Unit ={
    val twice: Int => Int = x => x*2
    val result: Int = Compose.compose(twice,twice)(5)
    val result2: Int = Compose.compose(_-1, twice)(5)
    assertEquals(20, result)
    assertEquals(9, result2)

    val toInt: String => Int = {
      case n if n == "True" => 1
      case n if n == "False" => 0
      case _ => 0
    }

    val toBool: Int => Boolean = {
      case n if n == 1 => true
      case n if n == 0 => false
      case _ => false
    }

    val strToBool = Compose.composeGeneral(toBool, toInt)
    assertEquals(true, strToBool("True"))
    assertEquals(false, strToBool("False"))
    assertEquals(false, strToBool("OtherString"))
  }

  val x: Rectangle = Rectangle(5, 10)
  val y: Square = Square(10)
  val z: Circle = Circle(5)

  @Test def testArea(): Unit ={
    assertEquals(50, area(x))
    assertEquals(30, perimeter(x))
    assertEquals(100, area(y))
    assertEquals(40, perimeter(y))
    assertEquals(78,area(z).toInt)
    assertEquals(31,perimeter(z).toInt)
  }
}
