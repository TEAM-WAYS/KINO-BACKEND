package ways.kinobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ways.kinobackend.DTO.ApiResponse;
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
        List<User> userList = userService.getUser();

        if (userList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userList);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(userList);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> postUser(@RequestBody User user) {

        Optional<User> savedUser = userService.postUser(user);

        if (savedUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User didn't save");
        }
    }

    @PutMapping("/users")
    public ResponseEntity<ApiResponse> putUser(@RequestBody User user) {
        Optional<User> updatedUser = userService.putUser(user);

        if (updatedUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("User updated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found or couldn't be updated"));
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
