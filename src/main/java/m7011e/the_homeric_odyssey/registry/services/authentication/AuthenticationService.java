package m7011e.the_homeric_odyssey.registry.services.authentication;

import lombok.AllArgsConstructor;
import m7011e.the_homeric_odyssey.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.authentication.user.UserRowPermission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final List<UserRowPermission> rowPermission;

    public boolean hasReadPermission(User resource) {
        for (UserRowPermission row : rowPermission) {
            if (row.hasReadPermission(resource)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWritePermission(User resource) {
        for (UserRowPermission row : rowPermission) {
            if (row.hasWritePermission(resource)) {
                return true;
            }
        }
        return false;
    }

}
