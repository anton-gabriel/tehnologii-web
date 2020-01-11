package com.unitbv.resourcesmanager.model;

import javax.persistence.*;
import java.util.List;

/**
 * The type Role.
 */
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_right",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private List<Right> rights;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets rights.
     *
     * @return the rights
     */
    public List<Right> getRights() {
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
}
