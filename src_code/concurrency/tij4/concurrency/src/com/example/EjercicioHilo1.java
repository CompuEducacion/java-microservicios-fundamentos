package com.example;

public class EjercicioHilo1 implements Runnable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EjercicioHilo1(String name) {
        this.name=name;
        System.out.println("Startup...");
    }

    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            System.out.println("Iteración: " + i + " de [" + this + "]");
            Thread.yield();
        }
        System.out.println("Hilo " + name + "finalizado!");
    }

    @Override
    public String toString() {
        return "EjercicioHilo1{" +
                "name='" + name + '\'' +
                '}';
    }
}
