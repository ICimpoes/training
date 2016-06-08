implicit val s: String = "implicit string"

def pref(p: String) = { p + implicitly[String] }

pref("aa ")

val l1 = 10l
val l2 = 101
