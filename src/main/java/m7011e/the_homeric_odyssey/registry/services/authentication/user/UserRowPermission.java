package m7011e.the_homeric_odyssey.registry.services.authentication.user;

import m7011e.the_homeric_odyssey.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.authentication.AuthenticationRowPermission;
import org.springframework.stereotype.Component;

@Component
public interface UserRowPermission extends AuthenticationRowPermission<User> {

    @Override
    default boolean hasReadPermission(User resource) {
        return false;
    }

    @Override
    default boolean hasWritePermission(User resource){
        return false;
    }
}
