package it.unisa.supermarket;

import java.util.Comparator;

public class ProductComparatorByCode implements Comparator<Product> {
    @Override
    public int compare(Product p,Product q)
    {
        return p.getCode().compareTo(q.getCode());
    }
}
