package imdb.com.user.controller;


import imdb.com.user.entity.Users;
import imdb.com.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@AllArgsConstructor

public class AuthController {
    UserService userService;

    @RequestMapping("/signup")
    @PostMapping
    public ResponseEntity<String> userSignup(@RequestBody Users user) {
        user.setPassword(this.userService.hashPassword(user.getPassword()));

        Users u = this.userService.addUser(user);
        System.out.println("user object: " + u);
        if (u != null) {
            return new ResponseEntity<>("successsfully registered user", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("unable to register user", HttpStatus.BAD_REQUEST);
        }
    }
}
