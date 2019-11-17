package utils;

import model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Server pool.
 */
public class ServerPool {
    private  Set<String> users;
    private static ServerPool instance = null;

    private ServerPool() {
        this.users = new HashSet<>();
    }

    /**
     * Add user.
     *
     * @param user the user
     * @return the result of adding operation
     */
    public Boolean addUser(User user) {
        if (this.users.contains(user.getUsername())) {
            return false;
        }
        this.users.add(user.getUsername());
        return true;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ServerPool getInstance()
    {
        if (instance == null)
            instance = new ServerPool();
        return instance;
    }
}
