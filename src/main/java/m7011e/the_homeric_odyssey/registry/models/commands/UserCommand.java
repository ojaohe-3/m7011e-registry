package m7011e.the_homeric_odyssey.registry.models.commands;

import lombok.Data;

@Data
public class UserCommand {
    private String clientId;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
