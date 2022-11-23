package it.unisa.supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Supermarket {

    private final List<Product> products;

    public Supermarket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        this.products.add(p);
        products.sort(new ProductComparatorByCode());
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getProductType(int i) {
        Product p = products.get(i);
        if (p.getClass() == Electronic.class) return "Electronic";
        if (p.getClass() == Grocery.class) return "Grocery";
        else return null;
    }

    public Product getMinPrice() {
        ProductComparatorByPrice p = new ProductComparatorByPrice();
        Product min = products.get(0);
        for (Product e : products) {
            if (p.compare(min, e) > 0) min = e;
        }
        return min;
    }

    public Product getMaxPrice() {
        ProductComparatorByPrice p = new ProductComparatorByPrice();
        Product max = products.get(0);
        for (Product e : products) {
            if (p.compare(max, e) < 0) max = e;
        }
        return max;
    }

    public List<Product> find(String brand) {
        List<Product> byBrand = new ArrayList<>();
        for (Product p : products) {
            if (p.getBrand().equals(brand)) byBrand.add(p);
        }
        return byBrand;
    }
}