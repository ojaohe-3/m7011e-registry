package m7011e.the_homeric_odyssey.registry.services.validation;

import m7011e.the_homeric_odyssey.registry.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.validation.user.UserValidationRow;
import m7011e.the_homeric_odyssey.resource_server.exceptions.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class CompositeUserValidator {

    private final List<UserValidationRow> rows;

    public CompositeUserValidator(List<UserValidationRow> rows) {
        this.rows = rows;
    }

    public void validate(User user) {
        Errors errors = new BeanPropertyBindingResult(user, "user");
        for (UserValidationRow row : rows) {
            row.validate(user, errors);
        }

        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
    }
}
