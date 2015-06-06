import week4._
  def nth[T](n: Int, list: List[T]): T = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    if (n == 0) list.head
    else nth[T](n - 1, list.tail)
  }
  val list = new Cons(1, new Cons(2, new Cons(3, new Nil())))
  nth(2, list)
//  nth(4, list)
  val f = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * v1
  }
  f(7)
  val f2: Int => Int = x => x * x
  f2(7)


  val l1 = List()
  val l2 = List(3)
  val l3 = List(3, 4)



