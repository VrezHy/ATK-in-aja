package model.entity;

public class Transaction {
    private String buyerUsername;
    private String productId;
    private int quantity;
    private double totalPrice;

    public Transaction(String buyerUsername, String productId, int quantity, double totalPrice) {
        this.buyerUsername = buyerUsername;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Pembeli: " + buyerUsername + ", ID Produk: " + productId + ", Jumlah: " + quantity + ", Total Harga: " + totalPrice;
    }
}
