package model.data;

import model.entity.atk;

import java.util.ArrayList;
import java.util.List;

public class atkList {
    private List<atk> products;

    public atkList() {
        products = new ArrayList<>();

        //data dummy
        products.add(new atk("P001", "Pulpen", 1000.0, 100));
        products.add(new atk("P002", "Buku", 5000.0, 50));
        products.add(new atk("P003", "Penghapus", 2000.0, 200));
    }

    public void addProduct(atk product) {
        products.add(product);
    }

    public List<atk> getProducts() {
        return products;
    }

    public atk findProductById(String id) {
        for (atk product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(atk product) {
        products.remove(product);
    }
}
