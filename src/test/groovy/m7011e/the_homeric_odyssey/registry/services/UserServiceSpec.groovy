package m7011e.the_homeric_odyssey.registry.services

import m7011e.the_homeric_odyssey.registry.models.domain.User
import m7011e.the_homeric_odyssey.registry.services.authentication.AuthenticationService
import m7011e.the_homeric_odyssey.registry.services.validation.CompositeUserValidator
import m7011e.the_homeric_odyssey.resource_server.exceptions.ForbiddenException
import org.modelmapper.ModelMapper
import spock.lang.Specification

class UserServiceSpec extends Specification {

    def "test createUser"() {
        setup:
        def userPersistenceService = Mock(UserPersistenceService)
        def compositeUserValidator = Mock(CompositeUserValidator)
        def compositeUserAuthentication = Mock(AuthenticationService)
        def modelMapper = Mock(ModelMapper)
        def userService = new UserService(userPersistenceService, compositeUserValidator, compositeUserAuthentication, modelMapper)
        def user = new User()

        when:
        def result = userService.createUser(user)

        then:
        1 * compositeUserValidator.validate(user)
        1 * userPersistenceService.createUser(user) >> user
        result == user
    }

    def "test getUser with permission"() {
        setup:
        def userPersistenceService = Mock(UserPersistenceService)
        def compositeUserValidator = Mock(CompositeUserValidator)
        def compositeUserAuthentication = Mock(AuthenticationService)
        def modelMapper = Mock(ModelMapper)
        def userService = new UserService(userPersistenceService, compositeUserValidator, compositeUserAuthentication, modelMapper)
        def user = new User(id: UUID.randomUUID())

        when:
        def result = userService.getUser(user.id)

        then:
        1 * userPersistenceService.getUserById(user.id) >> user
        1 * compositeUserAuthentication.hasReadPermission(user) >> true
        result == user
    }

    def "test getUser without permission throws ForbiddenException"() {
        setup:
        def userPersistenceService = Mock(UserPersistenceService)
        def compositeUserValidator = Mock(CompositeUserValidator)
        def compositeUserAuthentication = Mock(AuthenticationService)
        def modelMapper = Mock(ModelMapper)
        def userService = new UserService(userPersistenceService, compositeUserValidator, compositeUserAuthentication, modelMapper)
        def user = new User(id: UUID.randomUUID())

        when:
        userService.getUser(user.id)

        then:
        1 * userPersistenceService.getUserById(user.id) >> user
        1 * compositeUserAuthentication.hasReadPermission(user) >> false
        thrown(ForbiddenException)
    }

    def "test updateUser with permission"() {
        setup:
        def userPersistenceService = Mock(UserPersistenceService)
        def compositeUserValidator = Mock(CompositeUserValidator)
        def compositeUserAuthentication = Mock(AuthenticationService)
        def modelMapper = Mock(ModelMapper)
        def userService = new UserService(userPersistenceService, compositeUserValidator, compositeUserAuthentication, modelMapper)
        def existingUser = new User(id: UUID.randomUUID(), version: 1)
        def updatedUser = new User()

        when:
        def result = userService.updateUser(existingUser.id, updatedUser)

        then:
        1 * userPersistenceService.getUserById(existingUser.id) >> existingUser
        1 * compositeUserAuthentication.hasWritePermission(existingUser) >> true
        1 * compositeUserValidator.validate(updatedUser)
        1 * modelMapper.map(updatedUser, existingUser)
        1 * userPersistenceService.updateUser(existingUser) >> existingUser
        result == existingUser
    }

    def "test updateUser without permission throws ForbiddenException"() {
        setup:
        def userPersistenceService = Mock(UserPersistenceService)
        def compositeUserValidator = Mock(CompositeUserValidator)
        def compositeUserAuthentication = Mock(AuthenticationService)
        def modelMapper = Mock(ModelMapper)
        def userService = new UserService(userPersistenceService, compositeUserValidator, compositeUserAuthentication, modelMapper)
        def existingUser = new User(id: UUID.randomUUID(), version: 1)
        def updatedUser = new User()

        when:
        userService.updateUser(existingUser.id, updatedUser)

        then:
        1 * userPersistenceService.getUserById(existingUser.id) >> existingUser
        1 * compositeUserAuthentication.hasWritePermission(existingUser) >> false
        thrown(ForbiddenException)
    }

    def "test getUserByEmail"() {
        setup:
        def userPersistenceService = Mock(UserPersistenceService)
        def compositeUserValidator = Mock(CompositeUserValidator)
        def compositeUserAuthentication = Mock(AuthenticationService)
        def modelMapper = Mock(ModelMapper)
        def userService = new UserService(userPersistenceService, compositeUserValidator, compositeUserAuthentication, modelMapper)
        def email = "test@example.com"
        def user = new User(email: email)

        when:
        def result = userService.getUserByEmail(email)

        then:
        1 * userPersistenceService.getUserByEmail(email) >> user
        result == user
    }
}
