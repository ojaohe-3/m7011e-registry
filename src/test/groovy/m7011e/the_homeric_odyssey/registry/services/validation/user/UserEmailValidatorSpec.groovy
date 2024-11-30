package m7011e.the_homeric_odyssey.registry.services.validation.user

import m7011e.the_homeric_odyssey.registry.models.domain.User
import org.springframework.validation.BeanPropertyBindingResult
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class UserEmailValidatorSpec extends Specification {

    @Shared
    private UserEmailValidator validator = new UserEmailValidator()


    def "should validate user email and add error if invalid"() {
        given:
        def user = new User(email: email)
        def errors = new BeanPropertyBindingResult(user, "user")

        when:
        validator.validate(user, errors)

        then:
        errors.hasErrors() == expectedError

        where:
        email                 || expectedError
        "valid.email@test.com" | false
        "invalid-email@"       | true
        "another-invalid.com"  | true
        "test@valid.com"       | false
    }
}
