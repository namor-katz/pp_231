package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
//    @JoinColumn(name = "user_id", nullable = false)
    private Set<User> users;


    //constructors
    public Role() {};

    public Role(String role) {
        this.role = role;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    //implements

    @Override
    public String getAuthority() {
        return getRole();
    }
}

