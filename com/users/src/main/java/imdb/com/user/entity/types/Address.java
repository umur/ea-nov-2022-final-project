package imdb.com.user.entity.types;

import imdb.com.user.entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String state;
    private String city;
    private String zip;
    private String street;

    @OneToOne
    Users user;
}
