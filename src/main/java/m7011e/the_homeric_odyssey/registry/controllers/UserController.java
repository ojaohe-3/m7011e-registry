package m7011e.the_homeric_odyssey.registry.controllers;

import lombok.AllArgsConstructor;
import m7011e.the_homeric_odyssey.registry.api.UserApi;
import m7011e.the_homeric_odyssey.registry.models.commands.UserCommand;
import m7011e.the_homeric_odyssey.registry.models.domain.User;
import m7011e.the_homeric_odyssey.registry.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController implements UserApi {

    private final ModelMapper modelMapper;

    private final UserService userService;

    @PreAuthorize("hasAnyRole('SYSTEM', 'WRITE', 'READ')")
    @Override
    public ResponseEntity<User> createUser(@RequestBody UserCommand userCommand) {
        User user = modelMapper.map(userCommand, User.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PreAuthorize("hasAnyAuthority('VENDOR', 'SYSTEM', 'CUSTOMER', 'READ')")
    @Override
    public ResponseEntity<User> getUserById(UUID id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @Override
    @PreAuthorize("hasAnyAuthority('VENDOR', 'SYSTEM', 'CUSTOMER', 'READ')")
    public ResponseEntity<User> getUserByEmail(String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PreAuthorize("hasAnyAuthority('VENDOR', 'SYSTEM', 'CUSTOMER', 'WRITE')")
    @Override
    public ResponseEntity<User> updateUser(UUID id, UserCommand userCommand) {
        User user = modelMapper.map(userCommand, User.class);
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
}
