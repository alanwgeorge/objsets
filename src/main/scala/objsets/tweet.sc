import objsets._

val t1 = new Tweet("alan", "G", 0)
val t2 = new Tweet("alan", "A", 3)
val t3 = new Tweet("george", "F", 1)
val t4 = new Tweet("george", "E", 11)
val t5 = new Tweet("george", "Q", 21)
val t6 = new Tweet("george", "Z", 6)
val t7 = new Tweet("george", "W", 8)
val ts1 = new NonEmpty(t1, new Empty, new Empty).incl(t2).incl(t3).incl(t4).incl(t5).incl(t6).incl(t7)

ts1.filter(_.retweets > 1)
ts1.foreach(println(_))
ts1.mostRetweeted
val ts2 = new NonEmpty(t1, new Empty, new Empty)
println(ts2.mostRetweeted)
val ts3 = ts2.remove(ts2.mostRetweeted)
if (ts3.isInstanceOf[Empty]) println("yes")
else println("no")
ts1.descendingByRetweet.count
val list: TweetList = new Cons(t1, new Cons(t2, Nil))
list.count
TweetReader.allTweets.count