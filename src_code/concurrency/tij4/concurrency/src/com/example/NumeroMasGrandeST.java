package com.example;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

public class NumeroMasGrandeST {
        public static void main(String[] args) {
            Instant inicio = Instant.now();
            int[] data = new int[1024 * 1024 * 1024]; //1G  
            for (int i = 0; i < data.length; i++) {
                data[i] = ThreadLocalRandom.current().nextInt();
            }
            int max = Integer.MIN_VALUE;
            for (int value : data) {
            if (value > max) {
                max = value;
            }
             }
            Instant fin = Instant.now();
            System.out.println("Tiempo[" + (inicio.until(fin, ChronoUnit.MILLIS)) + "]\n Valor máximo:" + max);




        }
}

