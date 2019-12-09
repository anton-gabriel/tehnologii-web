package model;

/**
 * The type User test.
 */
class UserTest {

    /**
     * Test getId method.
     */
    @org.junit.jupiter.api.Test
    void getId() {
        int id = 0;
        User user = new User.UserBuilder("Gabi").setId(id).build();
        assert user.getId() == id;
    }

    /**
     * Test getPassword method.
     */
    @org.junit.jupiter.api.Test
    void getPassword() {
        String password = "pass";
        User user = new User.UserBuilder("Gabi").setPassword(password).build();
        assert user.getPassword().equals(password);
    }

    /**
     * Test setPassword method.
     */
    @org.junit.jupiter.api.Test
    void setPassword() {
        String password = "pass";
        User user = new User.UserBuilder("Gabi").setPassword(password).build();
        assert user.getPassword().equals(password);
    }

    /**
     * Test getUsername method.
     */
    @org.junit.jupiter.api.Test
    void getUsername() {
        String username = "Gabi";
        User user = new User.UserBuilder(username).build();
        assert user.getUsername().equals(username);
    }

    /**
     * Test setUsername method.
     */
    @org.junit.jupiter.api.Test
    void setUsername() {
        String username = "Gabi";
        User user = new User.UserBuilder(username).build();
        assert user.getUsername().equals(username);
    }
}