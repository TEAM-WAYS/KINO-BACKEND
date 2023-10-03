package ways.kinobackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ways.kinobackend.model.User;
import ways.kinobackend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> postUser(User user){
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> putUser(User user){
        Optional<User> foundUser = userRepository.findById(user.getId());

        if (foundUser.isPresent()){
            return Optional.of(userRepository.save(user));
        } else return Optional.empty();
    }

    @Override
    public boolean deleteUser(int id) {
        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isPresent()){
            userRepository.delete(foundUser.get());
            return true;
        }

        return false;
    }
}
