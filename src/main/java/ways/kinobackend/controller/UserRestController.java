package ways.kinobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ways.kinobackend.model.User;
import ways.kinobackend.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser() {
        List<User> movieList = userService.getUser();

        if (movieList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movieList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieList);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> postUser(@RequestBody User user){
        Optional<User> savedUser = userService.postUser(user);

        if (savedUser.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user didn't save");
        }
    }

    @PutMapping("/users")
    public ResponseEntity<?> putUser(@RequestBody User user){
        Optional<User> foundUser = userService.putUser(user);

        if (foundUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user didn't update");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(foundUser);
        }
    }
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        Boolean movieFound = userService.deleteUser(id);

        if (movieFound){
            return ResponseEntity.status(HttpStatus.OK).body("user deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not deleted");
        }
    }
}
