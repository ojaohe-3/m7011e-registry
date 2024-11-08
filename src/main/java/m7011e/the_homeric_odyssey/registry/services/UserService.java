package m7011e.the_homeric_odyssey.registry.services;

import lombok.SneakyThrows;
import m7011e.the_homeric_odyssey.registry.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.validation.CompositeUserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserPersistenceService userPersistenceService;

    private final CompositeUserValidator compositeUserValidator;
    private final ModelMapper modelMapper;

    public UserService(UserPersistenceService userPersistenceService, CompositeUserValidator compositeUserValidator, ModelMapper modelMapper) {
        this.userPersistenceService = userPersistenceService;
        this.compositeUserValidator = compositeUserValidator;
        this.modelMapper = modelMapper;
    }

    public User createUser(User user) {
        compositeUserValidator.validate(user);
        return userPersistenceService.createUser(user);
    }

    @SneakyThrows
    public User getUser(UUID id) {
        return userPersistenceService.getUserById(id);
    }

    @SneakyThrows
    public User updateUser(UUID id, User user) {
        User toUpdate = userPersistenceService.getUserById(id);
        user.setId(toUpdate.getId());
        user.setVersion(toUpdate.getVersion());
        compositeUserValidator.validate(user);
        modelMapper.map(user, toUpdate);

        return userPersistenceService.updateUser(toUpdate);
    }
}
