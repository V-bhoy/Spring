package com.entity;

public class Certificate {
   private String name;

   public Certificate(String name) {
       this.name = name;
   }

    @Override
    public String toString() {
        return "Certificate{" +
                "name='" + name + '\'' +
                '}';
    }
}
