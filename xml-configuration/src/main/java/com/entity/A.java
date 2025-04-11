package com.entity;

public class A {
    private int x;
    private B bInstance;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public B getbInstance() {
        return bInstance;
    }

    public void setbInstance(B bInstance) {
        this.bInstance = bInstance;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", bInstance=" + bInstance +
                '}';
    }
}
