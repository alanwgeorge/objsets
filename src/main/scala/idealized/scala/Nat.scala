package idealized.scala

// Peano numbers
abstract class Nat {
  def value: Int
  def isZero: scala.Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
  override def toString: String = value.toString
}

object Zero extends Nat {
  override def isZero: scala.Boolean = true
  override def successor: Nat = new Succ(this)
  override def +(that: Nat): Nat = {
    println("+:this:" + value + " that:" + that)
    that
  }
  override def -(that: Nat): Nat = if (that.isZero) this else throw new IllegalArgumentException
  override def predecessor: Nat = throw new IllegalArgumentException
  override def value: Int = 0
}

class Succ(n: Nat) extends Nat {
  override def isZero: scala.Boolean = false
  override def successor: Nat = new Succ(this)
  override def +(that: Nat): Nat = {
    println("+:this:" + value + " that:" + that)
    new Succ(n + that)
  }
  override def -(that: Nat): Nat = {
    if (that.isZero) this else {
      println("-:this:" + value + " that:" + that)
      n - that.predecessor
    }
  }
  override def predecessor: Nat = n

  override def value: Int = n.value + 1
}

object Main extends App {
  val zero = Zero
  zero.successor.successor
  val one = new Succ(zero)
  val two = new Succ(one)
  val three = new Succ(two)
  val four = new Succ(three)
  val five = new Succ(four)
  one + two
  five + five
  two - one
}