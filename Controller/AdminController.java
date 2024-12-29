package Controller;

import model.data.atkList;
import model.entity.atk;
import model.data.atkTransactionList;
import java.util.Scanner;

public class AdminController {
    private atkList productList;
    private atkTransactionList transactionList;

    public AdminController(atkList productList) {
        this.productList = productList;
    }

    public void kelolaProducts(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Tambahkan Produk");
            System.out.println("2. Edit Produk");
            System.out.println("3. Hapus Produk");
            System.out.println("4. Lihat Produk");
            System.out.println("5. history Transaksi pembeli");
            System.out.println("6. Keluar");
            System.out.print("Pilih Opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    editProduct(scanner);
                    break;
                case 3:
                    deleteProducts(scanner);
                    break;
                case 4:
                    viewProducts();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
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

    private void editProduct(Scanner scanner) {
        System.out.print("edit ID Produk: ");
        String id = scanner.next();
        System.out.print("Edit Nama Produk: ");
        String name = scanner.next();
        System.out.print("Edit Harga Produk: ");
        double price = scanner.nextDouble();
        System.out.print("Edit Stok Produk: ");
        int stock = scanner.nextInt();
        atk product = new atk(id, name, price, stock);
        productList.addProduct(product);
        System.out.println("Produk berhasil Diedit!");
    }

    private void deleteProducts(Scanner scanner) {
        System.out.print("Masukkan ID Produk yang ingin dihapus: ");
        String productId = scanner.next();

        atk product = productList.findProductById(productId);

        if (product == null) {
            System.out.println("Produk tidak ditemukan.");
        } else {
            productList.removeProduct(product);
            System.out.println("Produk berhasil dihapus!");
        }
    }

    private void viewProducts() {
        System.out.println("\n=== List Produk ===");
        for (atk product : productList.getProducts()) {
            System.out.println(product);
        }
    }

    private void viewTransactionHistory() {
        System.out.println("\n=== History Transaksi ===");
        transactionList.printAllTransactions();
    }

}
