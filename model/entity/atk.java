package model.entity;

public class atk {
    private String id;
    private String name;
    private double price;
    private int stock;

    private atk next;
    private atk previous;

    public atk(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.next = null; 
        this.previous = null;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    

    public atk getNext() {
        return next;
    }

    public void setNext(atk next) {
        this.next = next;
    }

    public atk getPrevious() {
        return previous;
    }

    public void setPrevious(atk previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (Harga: " + price + ", Stock: " + stock + ")";
    }
}
