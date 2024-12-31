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
            System.out.println("2. Tambahkan ke Keranjang dan Checkout");
            System.out.println("3. History Transaksi");
            System.out.println("4. Keluar");
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
                        viewTransactionHistory();
                        break;
                    case 4:
                        System.out.println("Kembali Halaman Login...");
                        return;
                    default:
                        System.out.println("Pilihan Tidak Valid.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang valid.");
                scanner.nextLine();
            }
        }
    }

    private void viewProducts() {
        System.out.println("\n=== Produk yang Tersedia ===");
        atk currentProduct = productList.getHead();
        while (currentProduct != null) {
            System.out.println(currentProduct);
            currentProduct = currentProduct.getNext();
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

        // Update stok produk berkurang pas dibeli
        product.setStock(product.getStock() - quantity);

        // Konfirmasi transaksi pas checkout
        System.out.println("\n=== Checkout ===");
        System.out.println("Masukkan Metode Pembayaran (Tunai, Kartu, E-Wallet, QRIS): ");
        String paymentMethod = scanner.next();

        System.out.println("Transaksi berhasil menggunakan " + paymentMethod + "!");
        System.out.println("Nama Produk : " + product.getName());
        System.out.println("Total harga : " + totalPrice);
    }

    
    private void viewTransactionHistory() {
        
        System.out.println("\n=== History Transaksi ===");
        if (transactionList == null || transactionList.getProductHead() == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        transactionList.printAllTransactions();
    }
    

}
