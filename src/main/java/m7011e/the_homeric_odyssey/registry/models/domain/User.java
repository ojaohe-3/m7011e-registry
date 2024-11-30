package m7011e.the_homeric_odyssey.registry.models.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class User {

    private UUID id;

    private int version;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private UserType userType;

    private UUID scopeId;

    private UUID sub;

}
