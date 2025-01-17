package m7011e.the_homeric_odyssey.registry.services;

import m7011e.the_homeric_odyssey.models.domain.User;
import m7011e.the_homeric_odyssey.registry_orm.orm.UserDb;
import m7011e.the_homeric_odyssey.registry.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional("transactionManager")
@Service
public class UserPersistenceService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserPersistenceService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public User createUser(User user) {
        UserDb userDb = modelMapper.map(user, UserDb.class);
        return mapEntity(userRepository.saveAndFlush(userDb));
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .map(this::mapEntity)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(this::mapEntity)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public User updateUser(User user) {
        UserDb userDb = modelMapper.map(user, UserDb.class);
        return mapEntity(userRepository.saveAndFlush(userDb));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    private User mapEntity(UserDb userDb) {
        return modelMapper.map(userDb, User.class);
    }
}