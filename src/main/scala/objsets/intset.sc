
abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}
object Empty extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x , Empty, Empty)
  override def union(other: IntSet): IntSet = other
  override def toString: String = "."
}
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def contains(x: Int): Boolean = {
    if (x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true
  }
  override def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem , left.incl(x), right)
    else if (x > elem) new NonEmpty(elem , left, right.incl(x))
    else this
  }

  override def toString: String = "{" + left + elem + right + "}"
  override def union(other: IntSet): IntSet = {
    ((left union right) union other ).incl(elem)
  }
}
val a1 = new NonEmpty(3, Empty, Empty)
val a2 = a1.incl(4)
val a3 = a2.incl(8)
val a4 = a3.incl(5)
val a5 = a4.incl(2)
a5.contains(6)

val b1 = new NonEmpty(50, Empty, Empty)
val b2 = b1.incl(66)
val b3 = b2.incl(45)
val b4 = b3.incl(-45)
val b5 = b4.incl(7)
val u1 = a5.union(b5)
u1.contains(45)


