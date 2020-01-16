package com.unitbv.resourcesmanager.dto;

import com.unitbv.resourcesmanager.utils.enums.RightType;

/**
 * The type Role dto.
 */
public class RoleDto {

    private long id;
    private RightType rightType;
    private String resourceName;

    /**
     * Gets right type.
     *
     * @return the right type
     */
    public RightType getRightType() {
        return rightType;
    }

    /**
     * Sets right type.
     *
     * @param rightType the right type
     */
    public void setRightType(RightType rightType) {
        this.rightType = rightType;
    }

    /**
     * Gets resource name.
     *
     * @return the resource name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Sets resource name.
     *
     * @param resourceName the resource name
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }
}
