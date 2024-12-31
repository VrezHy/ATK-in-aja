import Controller.AdminController;
import Controller.BuyerController;
import model.data.atkList;
import model.data.atkTransactionList;
import model.data.UserList;
import model.entity.User;

import java.util.Scanner;

public class Main {
    private static UserList userList = new UserList();
    private static atkList productList = new atkList();
    private static atkTransactionList transactionList = new atkTransactionList();

    public static void main(String[] args) {
        // Akun default
        userList.addUser(new User("admin", "admin123", "Admin"));
        userList.addUser(new User("user", "user123", "User"));
        userList.addUser(new User("user2", "user321", "User"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Aplikasi Beli Alat Tulis Kantor, ATK-in AJA ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        System.out.println("Keluar dari aplikasi...");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang valid.");
                scanner.nextLine();
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("\n=== Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai User");
        System.out.print("Pilih opsi: ");
        int loginChoice = scanner.nextInt();

        String role;
        if (loginChoice == 1) {
            role = "Admin";
        } else if (loginChoice == 2) {
            role = "User";
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.print("Masukkan username: ");
        String username = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        User user = userList.authenticate(username, password, role);

        if (user != null) {
            if ("Admin".equalsIgnoreCase(role)) {
                AdminController adminController = new AdminController(productList);
                adminController.kelolaProducts(scanner);
                System.out.println("Login berhasil! Selamat datang, " + user.getUsername() + ".");
            } else {
                BuyerController buyerController = new BuyerController(productList, transactionList);
                buyerController.buyerMenu(scanner, user.getUsername());
            }
        } else {
            System.out.println("Username, password, atau role salah. Coba lagi.");
        }
        
    }
}
