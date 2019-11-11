package utils;

import model.User;

import java.util.HashSet;
import java.util.Set;

public class ServerPool {
    private Set<String> users = new HashSet<>();

    public Boolean addUser(User user) {
        if (this.users.contains(user)) {
            return false;
        }
        this.users.add(user.getUsername());
        return true;
    }
}
