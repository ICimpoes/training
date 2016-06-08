package train

package object cakePattern {

  case class User(name: String, email: String, age: Int)

  class EntityManager {

    def createQuery(query: String) = Query(query)

    def persist(user: User) = {println(s"$user persisted")}
  }

  case class Query(query: String) {

    val ids: List[String] = if (query.trim.isEmpty) Nil else query.split(",").toList

    def resultSet: List[User] = {
      for {
        (k, user) <- userRepository.toList
        if ids.isEmpty || ids.contains(k)
      } yield user
    }
  }

  val userRepository = Map(
    "1" -> User("a", "a@mail.com", 18),
    "2" -> User("b", "b@mail.com", 13)
  )
}
