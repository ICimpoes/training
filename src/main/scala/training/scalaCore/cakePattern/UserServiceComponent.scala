package training.scalaCore.cakePattern

trait UserServiceComponent {

  def userService: UserService

  trait UserService {
    def findAll: List[User]

    def save(user: User)
  }

}

trait DefaultUserServiceComponent extends UserServiceComponent {
  this: UserRepositoryComponent =>

  def userService = new DefaultUserService

  class DefaultUserService extends UserService {
    def findAll = userLocator.findAll

    def save(user: User) {
      userUpdater.save(user: User)
    }
  }
}