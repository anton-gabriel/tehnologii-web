package com.unitbv.resourcesmanager.model;

import com.unitbv.resourcesmanager.utils.enums.RightType;

import javax.persistence.*;
import java.util.List;

/**
 * The type Right.
 */
@Entity
@Table(name="user_right")
public class Right {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "right_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private RightType name;

    @ManyToMany(mappedBy = "rights")
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
     * Gets name.
     *
     * @return the name
     */
    public RightType getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(RightType name) {
        this.name = name;
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
     * Gets role id.
     *
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets role id.
     *
     * @param roles the role id
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Right{" +
                "client=" + client.getEmail() +
                ", name=" + name +
                '}';
    }
}
