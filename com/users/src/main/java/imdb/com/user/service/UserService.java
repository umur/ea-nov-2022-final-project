package imdb.com.user.service;

import imdb.com.user.entity.Users;
import imdb.com.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public List<Users> getUsers() {
        return (List<Users>) this.userRepository.findAll();
    }

    public Users getUserById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public Users addUser(Users user) {
        return this.userRepository.save(user);
    }

    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    public String hashPassword(String p) {
        return BCrypt.hashpw(p, BCrypt.gensalt(12));
    }
}
