package model.data;

import model.entity.atk;
import model.entity.Transaction;

import java.util.LinkedList;
import java.util.List;

import Node.atkTransactionNode;

public class atkTransactionList {
    private atkTransactionNode productHead;
    public atkTransactionNode getProductHead() {
        return productHead;
    }

    // tambah transaksi ke produk tertentu
    // berisi data produk dan referensi ke data produk berikutnya
    // berisi data transaksi pertama
    // berisi data transaksi berikutnya
    // one to many satu produk memiliki banyak transaksi
    public void addTransaction(atk product, Transaction transaction) {
        if (productHead != null) {
            productHead = new atkTransactionNode(product, transaction);
        } else {
            atkTransactionNode currentProduct = productHead;
            while (currentProduct != null && !currentProduct.getProduct().getId().equals(product.getId())) {
                currentProduct = currentProduct.getNextProduct();
            }
            // tambahkan produk baru
            if (currentProduct == null) {
                atkTransactionNode newProductNode = new atkTransactionNode(product, transaction);
                newProductNode.setNextProduct(productHead);

                productHead = newProductNode;
            } else {
                // tambahkan transaksi ke produk tersebut
                atkTransactionNode currentTransaction = currentProduct;
                while (currentTransaction.getNextTransaction() != null) {
                    currentTransaction = currentTransaction.getNextTransaction();
                }
                currentTransaction.setNextTransaction(new atkTransactionNode(product, transaction));
            }
        }
    }

    // history transaksi
    // Node produk menyimpandata produk
    // Node Transaksi menyimpan detail transaksi
    public void printAllTransactions() {
        atkTransactionNode currentProduct = productHead;

        while (currentProduct != null) {
            System.out.println("Produk: " + currentProduct.getProduct().getName());
            atkTransactionNode currentTransaction = currentProduct.getNextTransaction();

            while (currentTransaction != null) {
                System.out.println("  - Transaksi: " + currentTransaction.getTransaction());
                currentTransaction = currentTransaction.getNextTransaction();
            }

            currentProduct = currentProduct.getNextProduct();
        }
    }

    
    //transaksi setiap username
    public List<Transaction> getTransactionsByUsername(String username) {
        List<Transaction> userTransactions = new LinkedList<>();
        atkTransactionNode currentProduct = productHead;
        while (currentProduct != null) {
            atkTransactionNode currentTransaction = currentProduct;
            while (currentTransaction != null) {
                if (currentTransaction.getTransaction().getBuyerUsername().equals(username)) {
                    userTransactions.add(currentTransaction.getTransaction());
                }
                currentTransaction = currentTransaction.getNextTransaction();
            }

            currentProduct = currentProduct.getNextProduct();
        }

        return userTransactions;
    }

}
