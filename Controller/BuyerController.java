package Controller;

import model.data.atkList;
import model.data.atkTransactionList;
import model.entity.atk;
import model.entity.Transaction;

import java.util.Scanner;

public class BuyerController {
    private atkList productList;
    private atkTransactionList transactionList;

    public BuyerController(atkList productList, atkTransactionList transactionList) {
        this.productList = productList;
        this.transactionList = transactionList;
    }

    public void buyerMenu(Scanner scanner, String username) {
        while (true) {
            System.out.println("\n=== Buyer Menu ===");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Tambahkan ke keranjang");
            System.out.println("3. Checkout");
            System.out.println("4. Lihat History Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih Opsi: ");
            try {
                int choice = scanner.nextInt(); 
                switch (choice) {
                    case 1:
                        viewProducts();
                        break;
                    case 2:
                        addToCart(scanner, username);
                        break;
                    case 3:
                        checkout(scanner, username);
                        break;
                    case 4:
                        viewTransactionHistory(username);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Pilihan Tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang valid.");
                scanner.nextLine(); // Menangani input yang tidak valid
            }
        }
    }

    private void viewProducts() {
        System.out.println("\n=== Produk yang tersedia ===");
        for (atk product : productList.getProducts()) {
            System.out.println(product);
        }
    }

    private void addToCart(Scanner scanner, String username) {
        System.out.print("Masukkan ID Produk: ");
        String productId = scanner.next();
        atk product = productList.findProductById(productId);

        if (product == null) {
            System.out.println("Produk tidak tersedia.");
            return;
        }

        System.out.print("Masukkan jumlah yang ingin dibeli: ");
        int quantity = scanner.nextInt();

        if (quantity > product.getStock()) {
            System.out.println("Stok yang tersedia tidak mencukupi.");
            return;
        }

        double totalPrice = product.getPrice() * quantity;
        Transaction transaction = new Transaction(username, productId, quantity, totalPrice);
        transactionList.addTransaction(product, transaction);

        // Update stock
        product.setStock(product.getStock() - quantity);

        System.out.println("Produk berhasil ditambahkan ke keranjang!");
        System.out.println("Total harga: " + totalPrice);
    }

    private void checkout(Scanner scanner, String username) {
        // Pastikan keranjang tidak kosong
        if (transactionList.getTransactionsByUsername(username).isEmpty()) {
            System.out.println("Keranjang Anda kosong. Silakan tambahkan produk terlebih dahulu.");
            return;
        }

        System.out.println("\n=== Checkout ===");
        System.out.println("Masukkan Metode Pembayaran (Tunai, Kartu, E-Wallet, Qris): ");
        String paymentMethod = scanner.next();

        System.out.println("Transaksi berhasil menggunakan " + paymentMethod + "!");
    }

    private void viewTransactionHistory(String username) {
        System.out.println("\n=== History Transaksi ===");
        // Mengambil transaksi berdasarkan username
        for (Transaction transaction : transactionList.getTransactionsByUsername(username)) {
            System.out.println(transaction);
        }
    }
}
