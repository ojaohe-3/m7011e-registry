package m7011e.the_homeric_odyssey.registry_orm.orm;

import jakarta.persistence.*;
import lombok.Data;
import m7011e.the_homeric_odyssey.models.domain.UserType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vendor_user")
@Data
public class UserDb {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    private int version;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @Column(nullable = false)

    private UserType userType;

    private UUID scopeId;

    private UUID sub;
}
