package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.*;

public class Fibonacci implements Callable<String> {

    private String name;
    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    public Fibonacci(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int fib(int n) {
        if (n <= 1) return n;
        else return fib(n - 1) + fib(n - 2);
    }

    public String fibToString() {
        StringJoiner sj =  new StringJoiner(",", "[", "]");
        for (int i = 0; i < n; i++) {
            sj.add(String.valueOf(fib(i)));
        }
        return sj.toString();
    }

    @Override
    public String toString() {
        return "Fibonacci('" +name + "'," +
                + n +
                ") = " + fibToString();
    }

    @Override
    public String call() {
        String res = this.toString();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci(10);
        System.out.println("Fibonacci de 10:" + fb.fibToString());

        List<String> listOfFibs = new ArrayList<>();

        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<String> f1 = es.submit(new Fibonacci(10, "T1"));
        Future<String> f2 = es.submit(new Fibonacci(20, "T2"));
        Future<String> f3 = es.submit(new Fibonacci(15, "T3"));
        Future<String> f4 = es.submit(new Fibonacci(16, "T4"));
        Future<String> f5 = es.submit(new Fibonacci(8, "T5"));
        Future<String> f6 = es.submit(new Fibonacci(13, "T6"));

        try {
            listOfFibs.add(f1.get());
            listOfFibs.add(f2.get());
            listOfFibs.add(f3.get());
            listOfFibs.add(f4.get());
            listOfFibs.add(f5.get());
            listOfFibs.add(f6.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();

        System.out.println("List de Resultados: " + listOfFibs);
    }


}
