package Controller;

import model.data.atkList;
import model.data.atkTransactionList;
import model.entity.atk;

import java.util.Scanner;

public class AdminController {
    private atkList productList;
    private atkTransactionList transactionList;
    

    public AdminController(atkList productList, atkTransactionList transactionList) {
        this.productList = productList;
        this.transactionList = transactionList;
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
            try {
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
                        System.out.println("Kembali Halaman Login...");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Harap pilih antara 1 hingga 6.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang sesuai.");
                scanner.nextLine();
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
        System.out.print("Masukkan ID Produk yang ingin diedit: ");
        String id = scanner.next();

        // cari produk berdasarkan ID
        atk product = productList.findProductById(id);
        if (product == null) {
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
            return;
        }
        // edit atribut produk
        System.out.print("Edit Nama Produk: ");
        scanner.nextLine(); 
        String name = scanner.nextLine();
        System.out.print("Edit Harga Produk: ");
        double price = scanner.nextDouble();
        System.out.print("Edit Stok Produk: ");
        int stock = scanner.nextInt();

        // perbarui data produk
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        System.out.println("Produk berhasil diedit!");
        System.out.println("Data produk terbaru: " + product);
    }

    // delete data produk
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
    // lihat data produk
    private void viewProducts() {
        System.out.println("\n=== Produk yang tersedia ===");
        atk currentProduct = productList.getHead();
        while (currentProduct != null) {
            System.out.println(currentProduct);
            currentProduct = currentProduct.getNext();
        }
    }

    // lihat transaksi pembeli
    private void viewTransactionHistory() {
        System.out.println("\n=== History Transaksi ===");
        if (transactionList == null || transactionList.getProductHead() == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        transactionList.printAllTransactions();
    }
    

}
