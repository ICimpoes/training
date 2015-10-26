import training.scalaCore.cakePattern._

val em = new EntityManager
val a = new UserRepositoryJPAComponent {
  override val em: EntityManager = em
}
em.createQuery("1").resultSet

val s1 = new DefaultUserServiceComponent with UserRepositoryJPAComponent {
  val em = new EntityManager
}

val s2 = new DefaultUserServiceComponent with UserRepositoryMockComponent
s1.userService.findAll
s1.userService.save(User("1", "2", 3))

s2.userService.findAll
s2.userService.save(User("1", "2", 3))
