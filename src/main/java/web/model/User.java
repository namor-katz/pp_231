package web.model;

import javax.persistence.*;
import java.util.Set;

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
    private int maxweight;

    @OneToMany  //(fetch = FetchType.LAZY, mappedBy = "users")
    @JoinColumn(name="roles")
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="roles")
    private Set<Role> roles;

    //constructors
    public User() {};

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, int maxweight) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.maxweight = maxweight;
    }

    public User(String name, String email, String password, int maxweight, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.maxweight = maxweight;
        this.roles = roles;
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

    public int getMaxweight() {
        return maxweight;
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

    public void setMaxweight(int maxWeight) {
        this.maxweight = maxWeight;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
