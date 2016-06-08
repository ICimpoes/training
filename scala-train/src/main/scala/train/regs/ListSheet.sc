val t = """(./[^/]+/[^/]+/[^/]+/[^/]+/[^/]+)/.*""".r

val s = "aae/partner/v1/partner/change-address/started/79677cb0-961a-41e7-985b-214c6a9e9ba1"

s match {
  case t(x) => x
  case _ => "aa"
}


