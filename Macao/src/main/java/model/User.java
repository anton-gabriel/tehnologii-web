package model;

import java.io.Serializable;

/**
 * The type User.
 */
public class User implements Serializable {

    private int id;
    private String password;
    private String username;

    /**
     * Instantiates a new User.
     *
     * @param builder the builder
     */
    public User(UserBuilder builder) {
        this.id = builder.id;
        this.password = builder.password;
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
        private String username;

        /**
         * Instantiates a new User builder.
         *
         * @param username the username
         */
        public UserBuilder(String username) {
            this.username = username;
        }

        /**
         * Sets password.
         *
         * @param password the password
         * @return the UserBuilder reference
         */
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        /**
         * Sets id.
         *
         * @param id the id
         * @return the UserBuilder reference
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
            return String.format("id = %d, username = %s",
                    id, username);
        }

    }
}

