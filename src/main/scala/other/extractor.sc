
trait User {
  def name: String
  def score: Int
}

class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] = Some((user.name, user.score, user.upgradeProbability))
}

object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}

val user: User = new PremiumUser("Alan", 10)
val puser: PremiumUser = new PremiumUser("George", 4)

user match {
  case FreeUser(name, _, _) => "Hello " + name
  case PremiumUser(name, _) => "Welcome back, dear " + name
}

user match {
  case free: FreeUser => "Hello " + free.name
  case prem: PremiumUser => "Welcome back, dear " + prem.name
}

val fuser: User = new FreeUser("Daniel", 3000, 0.5d)
fuser match {
  case FreeUser(name, _, p) => if (p > 0.75) name + ", what can we do for you today?" else "Hello " + name
  case PremiumUser(name, _) => "Welcome back, dear " + name
}

PremiumUser.unapply(puser)
val PremiumUser(name, score) = puser
object PremiumCandidate {
  def unapply(freeUser: FreeUser): Boolean = freeUser.upgradeProbability > .7
}

def printFreeUser(fu: FreeUser) = println("FreeUser = " + fu)
def printUser(u: User) = println("User = " + u)
fuser match {
  case freeUser @ PremiumCandidate() => printFreeUser(freeUser)
  case _ => printUser(fuser)
}

val o: Option[Int] = Some(5)
 o match {
   case Some(x) => println(x)
   case None =>
 }

o match {
  case x @ Some(_) => println(x)
  case None =>
}

o match {
  case x: Some[_] => println(x)
  case None =>
}

List(1 -> "one") map {t => (t._2, t._1)}
List(1 -> "one") map {case (x, y) => (y, x)}
val paf: PartialFunction[(Int, String), (String, Int)] = {case (x, y) => (y, x)}
List(1 -> "one") map (paf)

