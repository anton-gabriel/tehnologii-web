package com.unitbv.resourcesmanager.model;

import com.unitbv.resourcesmanager.utils.enums.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

/**
 * The type User.
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserRole type;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public UserRole getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(UserRole type) {
        this.type = type;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
