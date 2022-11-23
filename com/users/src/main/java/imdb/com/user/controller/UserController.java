package imdb.com.user.controller;

import imdb.com.user.entity.Users;
import imdb.com.user.service.UserService;
import imdb.com.user.rabbitmq.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private RabbitService rabbitService;

    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        List<Users> users = this.userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> addUser(@RequestBody Users user) {
        Users u = this.userService.addUser(user);
        if (u != null) {
            return new ResponseEntity<>("successsfully added user", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("unable to add user", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        this.userService.deleteUserById(id);

        this.rabbitService.sendMoviessMessage("delete " + id);
        return new ResponseEntity<>("successsfully deleted user", HttpStatus.OK);
    }
}
