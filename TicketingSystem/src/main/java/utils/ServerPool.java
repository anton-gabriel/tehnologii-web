package utils;

import model.User;

import java.util.HashSet;
import java.util.Set;

public class ServerPool {
    private  Set<String> users;
    private static ServerPool instance = null;

    private ServerPool() {
        this.users = new HashSet<>();
    }

    public Boolean addUser(User user) {
        if (this.users.contains(user.getUsername())) {
            return false;
        }
        this.users.add(user.getUsername());
        return true;
    }

    public static ServerPool getInstance()
    {
        if (instance == null)
            instance = new ServerPool();
        return instance;
    }
}
