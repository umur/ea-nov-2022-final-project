package imdb.com.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import imdb.com.user.entity.types.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String surname;

    private String username;
    private String password;
    private boolean owner = false;

    @OneToOne(mappedBy = "user")
    private Address address;
}
