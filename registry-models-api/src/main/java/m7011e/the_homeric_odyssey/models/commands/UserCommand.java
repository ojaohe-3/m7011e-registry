package m7011e.the_homeric_odyssey.models.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import m7011e.the_homeric_odyssey.models.domain.UserType;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCommand {
    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private UserType userType;

    private UUID sub;
}
