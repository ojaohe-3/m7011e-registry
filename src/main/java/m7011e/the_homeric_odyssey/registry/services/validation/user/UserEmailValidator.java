package m7011e.the_homeric_odyssey.registry.services.validation.user;

import m7011e.the_homeric_odyssey.models.domain.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserEmailValidator implements UserValidationRow {

    @Override
    public void validate(User user, Errors errors) {
        rejectOnCondition(() -> !EmailValidator.getInstance().isValid(user.getEmail()),
                errors,
                "email",
                "email.not.valid");
    }
}
