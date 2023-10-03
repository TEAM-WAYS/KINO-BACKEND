package ways.kinobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ways.kinobackend.model.User;

public interface UserRepository extends JpaRepository<User,String> {
}
