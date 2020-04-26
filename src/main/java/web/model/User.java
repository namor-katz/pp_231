package web.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "users")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Min(100)
    @Max(300)
    private int maxWeight;

    //constructors
    public User() {};

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, @Min(100) @Max(300) int maxWeight) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.maxWeight = maxWeight;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //getter's and setter's

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
