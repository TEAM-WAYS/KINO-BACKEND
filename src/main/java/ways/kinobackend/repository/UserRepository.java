package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findById(int id);
}
