package web.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
//    String ROLE_PREFIX = "ROLE_";   //может и не пригодится.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int maxweight;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)  //(fetch = FetchType.LAZY, mappedBy = "users")
//    @JoinColumn(name="roles")
    private Set<Role> roles;
//    @Column
//    private String roles;

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
    }

    public User(String name, String email, String password, int maxweight, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(Long id, String email, int maxweight, Set<Role> roles) {
        this.id = id;
        this.email = email;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getMaxweight() {
        return maxweight;
    }

    public void setMaxweight(int maxweight) {
        this.maxweight = maxweight;
    }

    //implements

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

