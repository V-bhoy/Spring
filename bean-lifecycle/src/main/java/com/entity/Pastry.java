package com.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pastry implements InitializingBean, DisposableBean {
    private String flavour;
    private double price;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pastry{" +
                "flavour='" + flavour + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("inside pastry destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       System.out.println("inside pastry after properties set");
    }
}
