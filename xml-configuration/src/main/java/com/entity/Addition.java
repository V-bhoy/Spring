package com.entity;

public class Addition {
    private int x;
    private int y;
    private int z;

    public Addition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        System.out.println("Args with int constructor called");
    }

    public Addition(double x, double y, double z) {
        this.x = (int) x;
        this.y = (int) y;
        this.z = (int) z;
        System.out.println("Args with double constructor called");
    }

    public Addition(int x, String y, double z) {
        this.x = x;
        this.y = Integer.parseInt(y);
        this.z = (int) z;
        System.out.println("Args with String constructor called");
    }

    public void doSum(){
        System.out.println("Sum is: " + (x + y + z));
    }
}
