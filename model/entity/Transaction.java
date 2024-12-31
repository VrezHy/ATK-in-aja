package model.entity;

public class Transaction {
    private String buyerUsername;
    private String name;
    private int quantity;
    private double totalPrice;

    public Transaction(String buyerUsername, String name, int quantity, double totalPrice) {
        this.buyerUsername = buyerUsername;
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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

    @Override
    public String toString() {
        return "Nama pembeli: " + buyerUsername + ", Nama produk: " + name + ", Jumlah: " + quantity + ", Total Harga: " + totalPrice;
    }
}
