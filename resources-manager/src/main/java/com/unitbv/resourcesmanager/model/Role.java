package com.unitbv.resourcesmanager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Role.
 */
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_right",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "right_id"))
    private List<Right> rights;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_user",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

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
     * Gets rights.
     *
     * @return the rights
     */
    public List<Right> getRights() {
        if (rights == null)
        {
            rights = new ArrayList<>();
        }
        return rights;
    }

    /**
     * Sets rights.
     *
     * @param rights the rights
     */
    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        if(users == null){
            users = new ArrayList<>();
        }
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rights=" + rights.toString() +
                '}';
    }
}
