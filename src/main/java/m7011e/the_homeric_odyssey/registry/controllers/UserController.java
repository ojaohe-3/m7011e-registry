package m7011e.the_homeric_odyssey.registry.controllers;

import m7011e.the_homeric_odyssey.registry.api.UserApi;
import m7011e.the_homeric_odyssey.registry.models.commands.UserCommand;
import m7011e.the_homeric_odyssey.registry.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/Users")
public class UserController implements UserApi {

    private final ModelMapper modelMapper;

    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> createUser(UserCommand userCommand) {
        User user = modelMapper.map(userCommand, User.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @Override
    public ResponseEntity<User> getUserById(UUID id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @Override
    public ResponseEntity<User> getUserByEmail(String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @Override
    public ResponseEntity<User> updateUser(UUID id, UserCommand userCommand) {
        User user = modelMapper.map(userCommand, User.class);
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
