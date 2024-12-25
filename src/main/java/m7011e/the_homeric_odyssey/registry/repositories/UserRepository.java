package m7011e.the_homeric_odyssey.registry.repositories;

import m7011e.the_homeric_odyssey.registry_orm.orm.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDb, UUID> {

    Optional<UserDb> findByEmail(String email);
}
