package u02

object Optionals extends App {

  sealed trait Option[A] // An Optional data type
  object Option {
    case class None[A]() extends Option[A]
    case class Some[A](a: A) extends Option[A]

    def isEmpty[A](opt: Option[A]): Boolean = opt match {
      case None() => true
      case _ => false
    }

    //B supertype of A
    //If opt is not empty get it's value, otherwise return orElse
    def getOrElse[A, B >: A](opt: Option[A], orElse: B): B = opt match {
      case Some(a) => a
      case _ => orElse
    }

    //??
    def flatMap[A,B](opt: Option[A])(f:A => Option[B]): Option[B] = opt match {
      case Some(a) => f(a)
      case _ => None()
    }

    def multiply(opt: Option[Int]): Int = opt match {
      case Some(a) => a * 2
      case _ => -1
    }

    def invert(opt: Option[Boolean]): Boolean = opt match {
      case Some(a) if a => false
      case Some(_) => true
      case _ => false //???
    }

    def filter[A](opt: Option[A])(predicate: A => Boolean) : Option[A] = opt match {
      case Some(a) if predicate(a) => Some(a)
      case _ => None()
    }

    //


  }

  import Option._
  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = None()

  val s4: Option[Int] = Some(2)
  println(multiply(s4))

  println(filter(s4)( _ > 3))
  println(s1) // Some(1)
  println(getOrElse(s1,0), getOrElse(s3,0)) // 1,0
  println(flatMap(s1)(i => Some(i+1))) // Some(2)
  println(flatMap(s1)(i => flatMap(s2)(j => Some(i+j)))) // Some(3)
  println(flatMap(s1)(i => flatMap(s3)(j => Some(i+j)))) // None
}
