package model;

import utils.enums.UserType;

public class User {

    private int id;
    private String password;
    private UserType type;
    private String username;

    public User(UserBuilder builder) {
        this.password = builder.password;
        this.type = builder.type;
        this.username = builder.username;
    }

    public int getId() { return id; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class UserBuilder {
        private String password;
        private UserType type;
        private String username;

        public UserBuilder(String username) {
            this.username = username;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setType(UserType type) {
            this.type = type;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

