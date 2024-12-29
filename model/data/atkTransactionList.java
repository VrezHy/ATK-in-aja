package model.data;

import model.entity.atk;
import model.entity.Transaction;

import java.util.LinkedList;
import java.util.List;

import Node.atkTransactionNode;

public class atkTransactionList {
    private atkTransactionNode productHead;

    // tambah transaksi ke produk tertentu
    public void addTransaction(atk product, Transaction transaction) {
        if (productHead == null) {
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
    public void printAllTransactions() {
        atkTransactionNode currentProduct = productHead;

        while (currentProduct != null) {
            System.out.println("Product: " + currentProduct.getProduct().getName());
            atkTransactionNode currentTransaction = currentProduct;
            while (currentTransaction != null) {
                System.out.println("  - Transaction: " + currentTransaction.getTransaction());
                currentTransaction = currentTransaction.getNextTransaction();
            }
            currentProduct = currentProduct.getNextProduct();
        }
    }

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
