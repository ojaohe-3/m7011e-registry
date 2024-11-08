package m7011e.the_homeric_odyssey.registry.services.validation.user;

import m7011e.the_homeric_odyssey.registry.models.domain.User;
import org.springframework.validation.Errors;

import java.util.function.Supplier;

public interface UserValidationRow {

    void validate(User user, Errors errors);

    default void rejectOnCondition(Supplier<Boolean> condition, Errors errors, String field, String errorCode) {
        if (condition.get()) {
            errors.rejectValue(field, errorCode);
        }
    }
}
