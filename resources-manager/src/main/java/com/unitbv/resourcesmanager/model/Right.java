package com.unitbv.resourcesmanager.model;

import com.unitbv.resourcesmanager.utils.enums.RightType;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;

/**
 * The type Right.
 */
@Entity
@Table(name="right")
public class Right {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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
}
