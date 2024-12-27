package Controller;

import model.data.atkList;
import model.entity.atk;
import java.util.Scanner;

public class AdminController {
    private atkList productList;

    public AdminController(atkList productList) {
        this.productList = productList;
    }

    public void manageProducts(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambahkan Produk");
            System.out.println("2. Lihat Produk");
            System.out.println("3. Exit");
            System.out.print("Pilih Opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.print("Masukkan ID Produk: ");
        String id = scanner.next();
        System.out.print("Masukkan Nama Produk: ");
        String name = scanner.next();
        System.out.print("Masukkan Harga Produk: ");
        double price = scanner.nextDouble();
        System.out.print("Masukkan Stok Produk: ");
        int stock = scanner.nextInt();

        atk product = new atk(id, name, price, stock);
        productList.addProduct(product);
        System.out.println("Produk berhasil Ditambahkan!");
    }

    private void viewProducts() {
        System.out.println("\n=== List Produk ===");
        for (atk product : productList.getProducts()) {
            System.out.println(product);
        }
    }
}
