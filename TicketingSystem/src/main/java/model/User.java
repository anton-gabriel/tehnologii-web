package model;

import utils.enums.UserType;

import java.io.Serializable;

/**
 * The type User.
 */
public class User implements Serializable {

    private int id;
    private String password;
    private UserType type;
    private String username;

    /**
     * Instantiates a new User.
     *
     * @param builder the builder
     */
    public User(UserBuilder builder) {
        this.id = builder.id;
        this.password = builder.password;
        this.type = builder.type;
        this.username = builder.username;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
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
        this.password = password;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public UserType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(UserType type) {
        this.type = type;
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
     * The type User builder.
     */
    public static class UserBuilder {

        private int id;
        private String password;
        private UserType type;
        private String username;

        /**
         * Instantiates a new User builder.
         *
         * @param username the username
         */
        public UserBuilder(String username) {
            this.username = username;
            this.type = UserType.USER;
        }

        /**
         * Sets password.
         *
         * @param password the password
         * @return the password
         */
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        /**
         * Sets type.
         *
         * @param type the type
         * @return the type
         */
        public UserBuilder setType(UserType type) {
            this.type = type;
            return this;
        }

        /**
         * Sets id.
         *
         * @param id the id
         * @return the id
         */
        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        /**
         * Build user.
         *
         * @return the user
         */
        public User build() {
            return new User(this);
        }

        @Override
        public String toString() {
            return String.format("id = %d, username = %s, type = %s",
                    id, username, type);
        }

    }
}

