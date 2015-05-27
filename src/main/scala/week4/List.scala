package week4

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty: Boolean = true
  override def head: Nothing = throw new NoSuchFieldException("Nil.head")
  override def tail: Nothing = throw new NoSuchFieldException("Nil.head")
}

object List {
  def apply[T](): List[T] = new Nil()
  def apply[T](v1: T): List[T] = new Cons(v1, new Nil())
  def apply[T](v1: T, v2: T): List[T] = new Cons(v1, new Cons(v2, new Nil()))
}