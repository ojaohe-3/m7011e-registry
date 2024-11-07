package m7011e.the_homeric_odyssey.registry.controllers;

import m7011e.the_homeric_odyssey.registry.api.UserApi;
import m7011e.the_homeric_odyssey.registry.models.commands.UserCommand;
import m7011e.the_homeric_odyssey.registry.models.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller(value = "apis/v1/users")
public class UserController implements UserApi {

    private final ModelMapper modelMapper;

    public UserController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<User> createUser(UserCommand user) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(UUID id, UserCommand user) {
        return null;
    }
}
