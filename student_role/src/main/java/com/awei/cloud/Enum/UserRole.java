package com.awei.cloud.Enum;

public enum UserRole {

    STUDNET("S"),
    TEACHER("T"),
    MANAGER("M")
    ;
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
