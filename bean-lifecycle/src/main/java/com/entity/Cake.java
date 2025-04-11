package com.entity;

public class Cake {
    private String flavour;
    private double price;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        System.out.println("Setting flavour");
        this.flavour = flavour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        System.out.println("Setting price");
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "flavour='" + flavour + '\'' +
                ", price=" + price +
                '}';
    }

    // every bean in spring has init and destroy method which can be of different name but
    // signature should be same that is public void method name

    public void init(){
        System.out.println("Inside init method");
    }

    public void destroy(){
        System.out.println("Inside destroy method");
    }
}
