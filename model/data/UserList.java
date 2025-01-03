package model.data;

import model.entity.User;
//SLL
public class UserList {
    private UserNode head;

    // Node dalam Multi-Linked List
    private static class UserNode {
        private User user;
        private UserNode next;

        public UserNode(User user) {
            this.user = user;
            this.next = null;
        }

        public User getUser() {
            return user;
        }

        public UserNode getNext() {
            return next;
        }

        public void setNext(UserNode next) {
            this.next = next;
        }
    }

    public UserList() {
        head = null;
    }

    // Menambahkan user baru
    public void addUser(User user) {
        UserNode newUserNode = new UserNode(user);
        if (head == null) {
            head = newUserNode;
        } else {
            UserNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newUserNode);
        }
    }

    // // ngecek apakah username sudah diambil (opsional)
    public boolean isUsernameTaken(String username) {
        UserNode current = head;
        while (current != null) {
            if (current.getUser().getUsername().equals(username)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // mengautentikasi berdasarkan username, password, dan role
    public User authenticate(String username, String password, String role) {
        UserNode current = head;
        while (current != null) {
            User user = current.getUser();
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password) &&
                    // case sensitive
                    user.getRole().equalsIgnoreCase(role)) {
                return user;
            }
            current = current.getNext();
        }
        return null;
    }

}
