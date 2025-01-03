package model.entity;

//Note :ku tambahin  private Transaction next ama previous dan line 36-50 ku samain kaya dari atk tapi outpunya cuman transaksi terakhir aja
public class Transaction {
    private String buyerUsername;
    private String name;
    private int quantity;
    private double totalPrice;
    private Transaction next;
    private Transaction previous;

    public Transaction(String buyerUsername, String name, int quantity, double totalPrice) {
        this.buyerUsername = buyerUsername;
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.next = null;
        this.previous = null;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Transaction getNext() {
        return next;
    }

    public void setNext(Transaction next) {
        this.next = next;
    }

    public Transaction getPrevious() {
        return previous;
    }

    public void setPrevious(Transaction previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Nama pembeli: " + buyerUsername + ", Nama produk: " + name + ", Jumlah: " + quantity + ", Total Harga: "
                + totalPrice;
    }

}
