
def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)

def modN(n: Int)(x: Int): Boolean = (x % n) == 0

def test(f: Int => Boolean): Boolean = {
  f(3)
}

val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

val part = modN(2)_

println(filter(nums, part))
println(filter(nums, modN(3)))
test(modN(3))

