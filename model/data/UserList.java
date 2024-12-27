package model.data;

import model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean isUsernameTaken(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public User authenticate(String username, String password, String role) {
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password) &&
                user.getRole().equalsIgnoreCase(role)) {
                return user;
            }
        }
        return null;
    }
}
