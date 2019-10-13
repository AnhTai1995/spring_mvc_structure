package tai.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import tai.example.demo.validate.DateValidate;

import javax.persistence.*;

/**
 * User entity
 *
 * @author TuMV
 */
@Entity
@Table(name = "user")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private int age;

    @DateValidate
    @Column(name = "birthday")
    private String birthday;
}
