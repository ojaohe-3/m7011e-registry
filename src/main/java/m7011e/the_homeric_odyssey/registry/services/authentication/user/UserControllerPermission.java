package m7011e.the_homeric_odyssey.registry.services.authentication.user;

import lombok.AllArgsConstructor;
import m7011e.the_homeric_odyssey.authentication_components.services.UserAuthenticationHelper;
import m7011e.the_homeric_odyssey.models.domain.User;
import m7011e.the_homeric_odyssey.resource_server.models.RealmUserType;

import java.util.Objects;

@AllArgsConstructor
public class UserControllerPermission implements UserRowPermission {

    private final UserAuthenticationHelper userAuthenticationHelper;


    @Override
    public boolean hasReadPermission(User resource) {
        if (userAuthenticationHelper.hasRole(RealmUserType.SYSTEM)
                || userAuthenticationHelper.hasRole(RealmUserType.ADMIN)) {
            return true;
        }

        return isInScope(resource)
                && (userAuthenticationHelper.hasAnyReadRole() || userAuthenticationHelper.hasAnyWriteRole());
    }

    @Override
    public boolean hasWritePermission(User resource) {
        return isInScope(resource) && (userAuthenticationHelper.hasRole(RealmUserType.SYSTEM)
                || userAuthenticationHelper.hasRole(RealmUserType.ADMIN)
                || userAuthenticationHelper.hasAnyWriteRole());
    }

    private boolean isInScope(User resource) {
        return Objects.equals(resource.getId().toString(),
                userAuthenticationHelper.getUserId().orElse(null)) ||
                userAuthenticationHelper.getUserScope()
                        .map(scope -> scope.contains(resource.getId().toString()))
                        .orElse(false);
    }
}
