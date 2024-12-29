package model.entity;

public class atk {
    private String id;
    private String name;
    private double price;
    private int stock;

    public atk(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (Harga: " + price + ", Stock: " + stock + ")";
    }
}
