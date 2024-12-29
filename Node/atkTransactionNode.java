package Node;

import model.entity.atk;
import model.entity.Transaction;

public class atkTransactionNode {
    private atk product;
    private Transaction transaction;
    private atkTransactionNode nextTransaction;
    private atkTransactionNode nextProduct; 
    public atkTransactionNode(atk product, Transaction transaction) {
        this.product = product;
        this.transaction = transaction;
        this.nextTransaction = null;
        this.nextProduct = null;
    }

    public atk getProduct() {
        return product;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public atkTransactionNode getNextTransaction() {
        return nextTransaction;
    }

    public void setNextTransaction(atkTransactionNode nextTransaction) {
        this.nextTransaction = nextTransaction;
    }

    public atkTransactionNode getNextProduct() {
        return nextProduct;
    }

    public void setNextProduct(atkTransactionNode nextProduct) {
        this.nextProduct = nextProduct;
    }
}
