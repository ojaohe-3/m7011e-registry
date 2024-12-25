package m7011e.the_homeric_odyssey.registry.services.validation.user

import m7011e.the_homeric_odyssey.models.domain.User
import org.springframework.validation.Errors
import spock.lang.Specification

class UserRequiredFieldSpec extends Specification {
    def "UserRequiredField validate method should reject missing fields"() {
        given: "A UserRequiredField validator and a user with missing fields"
        def userRequiredField = new UserRequiredField()
        def errors = Mock(Errors)
        def user = new User(email: null, userType: null)

        when: "The validate method is called"
        userRequiredField.validate(user, errors)

        then: "Errors object should reject missing email and userType"
        1 * errors.rejectValue("email", "email.is.required")
        1 * errors.rejectValue("userType", "userType.is.required")
    }
    
}
