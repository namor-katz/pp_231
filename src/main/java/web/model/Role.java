package web.model;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;

    //constructors
    public Role() {};

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

    //implements methods

    @Override
    public String getAuthority() {
        return getRole();
    }
}

