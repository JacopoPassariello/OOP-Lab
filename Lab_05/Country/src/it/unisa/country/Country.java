package it.unisa.country;

public class Country implements Comparable<Country> {

    final private String name;
    final private double surfaceArea;

    public Country(String name, double surfaceArea) {
        this.name = name;
        this.surfaceArea = surfaceArea;
    }

    public String getName() {
        return name;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public int compareTo(Country x)
    {
        if(x.getSurfaceArea() < this.surfaceArea) return 1;
        if(x.getSurfaceArea() > this.surfaceArea) return -1;
        else return 0;
     }

}