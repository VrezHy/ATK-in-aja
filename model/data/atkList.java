package model.data;

import model.entity.atk;

import java.util.ArrayList;
import java.util.List;

public class atkList {
    private List<atk> products;

    public atkList() {
        products = new ArrayList<>();
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
}
