package org.example.proiect_disertatie.repo;

import java.util.Optional;
import org.example.proiect_disertatie.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUsernameAndIsActive(String username, Boolean isActive);

}
