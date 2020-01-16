package com.unitbv.resourcesmanager.dto;

import com.unitbv.resourcesmanager.utils.enums.RightType;

public class RoleDto {
    private RightType rightType;
    private String resourceName;

    public RightType getRightType() {
        return rightType;
    }

    public void setRightType(RightType rightType) {
        this.rightType = rightType;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
