
trait User {
  def name: String
}
class FreeUser(val name: String) extends User
class PremiumUser(val name: String) extends User
object FreeUser {
  def unapply(user: FreeUser): Option[String] = Some(user.name)
}
object PremiumUser {
  def unapply(user: PremiumUser): Option[String] = Some(user.name)
}

val user: User = new PremiumUser("Alan")

user match {
  case FreeUser(name) => "Hello " + name
  case PremiumUser(name) => "Welcome back, dear " + name
}

user match {
  case free: FreeUser => "Hello " + free.name
  case prem: PremiumUser => "Welcome back, dear " + prem.name
}
