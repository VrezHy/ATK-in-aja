package model.data;

import model.entity.atk;
import model.entity.Transaction;
import Node.atkTransactionNode;

public class atkTransactionList {
    private atkTransactionNode head;

    public void addTransaction(atk product, Transaction transaction) {
        atkTransactionNode newNode = new atkTransactionNode(product, transaction);
        if (head == null) {
            head = newNode;
        } else {
            atkTransactionNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void printAllTransactions() {
        atkTransactionNode current = head;
        while (current != null) {
            System.out.println(current.getTransaction());
            current = current.getNext();
        }
    }
}
