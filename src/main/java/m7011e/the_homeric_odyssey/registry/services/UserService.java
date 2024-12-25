package m7011e.the_homeric_odyssey.registry.services;

import lombok.extern.slf4j.Slf4j;
import m7011e.the_homeric_odyssey.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.authentication.AuthenticationService;
import m7011e.the_homeric_odyssey.registry.services.validation.CompositeUserValidator;
import m7011e.the_homeric_odyssey.resource_server.exceptions.ForbiddenException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final UserPersistenceService userPersistenceService;

    private final CompositeUserValidator compositeUserValidator;

    private final AuthenticationService compositeUserAuthentication;

    private final ModelMapper modelMapper;

    public UserService(UserPersistenceService userPersistenceService, CompositeUserValidator compositeUserValidator, AuthenticationService compositeUserAuthentication, ModelMapper modelMapper) {
        this.userPersistenceService = userPersistenceService;
        this.compositeUserValidator = compositeUserValidator;
        this.compositeUserAuthentication = compositeUserAuthentication;
        this.modelMapper = modelMapper;
    }

    public User createUser(User user) {
        compositeUserValidator.validate(user);
        return userPersistenceService.createUser(user);
    }

    public User getUser(UUID id) {
        User userById = userPersistenceService.getUserById(id);

        if (!compositeUserAuthentication.hasReadPermission(userById)) {
            log.info("Failed to fetch User with id {}, lacks read permission", userById.getId());
            throw new ForbiddenException("User lacks read permission");
        }

        return userById;
    }

    public User updateUser(UUID id, User user) {
        User toUpdate = userPersistenceService.getUserById(id);
        user.setId(toUpdate.getId());
        user.setVersion(toUpdate.getVersion());

        if (!compositeUserAuthentication.hasWritePermission(toUpdate)) {
            log.info("Failed to update User with id {}, lacks write permission", toUpdate.getId());
            throw new ForbiddenException("User lacks write permission");
        }

        compositeUserValidator.validate(user);
        modelMapper.map(user, toUpdate);

        return userPersistenceService.updateUser(toUpdate);
    }

    public User getUserByEmail(String email) {
        return userPersistenceService.getUserByEmail(email);
    }
}
