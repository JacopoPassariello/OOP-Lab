package it.unisa.supermarket;

/* TODO */

import java.util.Comparator;

public class ProductComparatorByPrice implements Comparator<Product> {

    @Override
    public int compare(Product p,Product q)
    {
        return Double.compare(p.getPrice(),q.getPrice());
    }
}