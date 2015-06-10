package week4

trait Expr {
  def show: String = {
    this match {
      case Number(n) => n.toString
      case Var(n) => n
      case Sum(e1, e2) => e1.show + " + " + e2.show
      case Sum(e1, Prod(p1, p2)) => e1.show + " + (" + p1.show + " * " + p2.show + ")"
      case Prod(e1, e2) => e1.show + " * " + e2.show
      case _ => "error"
    }
  }
}
case class Number(n: Int) extends Expr
case class Var(name: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

object Main extends App {
//  val v = Sum(Sum(Number(44), Var("x")), Prod(Number(2), Number(3)))
  val v = Sum(Number(1), Prod(Number(2), Number(3)))
  println(v.show)
}