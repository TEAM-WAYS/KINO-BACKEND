package ways.kinobackend.service;

import ways.kinobackend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUser();

    Optional<User> postUser(User user);

    Optional<User> putUser(User user);

    boolean deleteUser(int id);

    Boolean deleteUserByPassword(User user);

    Optional<User> putUserByPassword(User user);
}
