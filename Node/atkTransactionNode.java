package Node;

import model.entity.atk;
import model.entity.Transaction;

public class atkTransactionNode {
    private atk product;
    private Transaction transaction;
    private atkTransactionNode next;

    public atkTransactionNode(atk product, Transaction transaction) {
        this.product = product;
        this.transaction = transaction;
        this.next = null;
    }

    public atk getProduct() {
        return product;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public atkTransactionNode getNext() {
        return next;
    }

    public void setNext(atkTransactionNode next) {
        this.next = next;
    }
}
