package m7011e.the_homeric_odyssey.registry.services.validation.user;

import liquibase.util.StringUtil;
import m7011e.the_homeric_odyssey.models.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Objects;
import java.util.function.Supplier;

@Component
public class UserRequiredField implements UserValidationRow {
    @Override
    public void validate(User user, Errors errors) {
        rejectOnCondition(emailExists(user), errors, "email", "email.is.required");
        rejectOnCondition(userTypeExists(user), errors, "userType", "userType.is.required");
    }

    private Supplier<Boolean> emailExists(User user) {
        return () -> StringUtil.isEmpty(user.getEmail());
    }

    private Supplier<Boolean> userTypeExists(User user) {
        return () -> Objects.isNull(user.getUserType());
    }
}
