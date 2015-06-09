import idealized.scala._

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