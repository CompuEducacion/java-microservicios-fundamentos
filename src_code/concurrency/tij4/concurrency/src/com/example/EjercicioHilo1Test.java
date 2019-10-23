package com.example;

public class EjercicioHilo1Test {
    public static void main(String[] args){
        EjercicioHilo1 eh1 = new EjercicioHilo1("h1");
        /*
        EjercicioHilo1 eh2 = new EjercicioHilo1("h2");
        EjercicioHilo1 eh3 = new EjercicioHilo1("h3");
        EjercicioHilo1 eh4 = new EjercicioHilo1("h4");
        EjercicioHilo1 eh5 = new EjercicioHilo1("h5");
        *
         */

        Thread t1 = new Thread(eh1);
        Thread t2 = new Thread(eh1);
        Thread t3 = new Thread(eh1);
        Thread t4 = new Thread(eh1);
        Thread t5 = new Thread(eh1);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
