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
        // Akun admin default
        userList.addUser(new User("admin", "admin123", "Admin"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Aplikasi Beli Alat Tulis Kantor, ATK-in AJA ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                int choice = scanner.nextInt(); // Menangkap input sebagai integer
                
                switch (choice) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        register(scanner);
                        break;
                    case 3:
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
            System.out.println("Login berhasil! Selamat datang, " + user.getUsername() + ".");
            if ("Admin".equalsIgnoreCase(role)) {
                AdminController adminController = new AdminController(productList);
                adminController.kelolaProducts(scanner);
            } else {
                BuyerController buyerController = new BuyerController(productList, transactionList);
                buyerController.buyerMenu(scanner, username);
            }
        } else {
            System.out.println("Username, password, atau role salah. Coba lagi.");
        }
    }

    private static void register(Scanner scanner) {
        System.out.println("\n=== Register ===");
        System.out.print("Masukkan username baru: ");
        String username = scanner.next();
        System.out.print("Masukkan password baru: ");
        String password = scanner.next();

        if (userList.isUsernameTaken(username)) {
            System.out.println("Username sudah digunakan. Silakan coba username lain.");
        } else {
            userList.addUser(new User(username, password, "User"));
            System.out.println("Registrasi berhasil! Silakan login menggunakan akun baru Anda.");
        }
    }
}
