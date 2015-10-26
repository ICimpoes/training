package training.scalaCore.cakePattern

trait UserRepositoryComponent {

  def userLocator: UserLocator

  def userUpdater: UserUpdater

  trait UserLocator {
    def findAll: List[User]
  }

  trait UserUpdater {
    def save(user: User)
  }

}

trait UserRepositoryJPAComponent extends UserRepositoryComponent {
  val em: EntityManager

  def userLocator = new UserLocatorJPA(em)

  def userUpdater = new UserUpdaterJPA(em)

  class UserLocatorJPA(val em: EntityManager) extends UserLocator {
    def findAll = em.createQuery("").resultSet
  }

  class UserUpdaterJPA(val em: EntityManager) extends UserUpdater {
    def save(user: User) {
      em.persist(user)
    }
  }
}

trait UserRepositoryMockComponent extends UserRepositoryComponent {

  def userLocator = new UserLocator {
    override def findAll: List[User] = Nil
  }

  def userUpdater = new UserUpdater {
    override def save(user: User): Unit = println("Mock")
  }
}