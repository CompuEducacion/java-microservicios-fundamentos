package fork_join;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class TareaOrdenaArreglo extends RecursiveAction {

    private final int[] datos;
    private int inicio;
    private int fin;

    public TareaOrdenaArreglo(int[] datos, int inicio, int fin) {
        this.datos = datos;
        this.inicio = inicio;
        this.fin = fin;
    }

    protected void compute() {
        int aux = 0;
        if (fin - inicio <= 1) {
            if(datos[inicio] > datos[fin]){
                aux = datos[inicio];
                datos[inicio] = datos[fin];
                datos[fin] = aux;
            }
        } else {
            int mitad = (fin - inicio) / 2 + inicio;
            TareaOrdenaArreglo a1 = new TareaOrdenaArreglo(datos, inicio, mitad);
            a1.fork();
            TareaOrdenaArreglo a2 = new TareaOrdenaArreglo(datos, mitad + 1, fin);
            a2.compute();
            a1.join();
        }
    }

    public static void main(String[] args) {


        //Genera datos
        int[] data = new int[1024];

        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(100);
        }

        Instant inicio = Instant.now();

        Arrays.stream(data).forEach(i -> System.out.println(i));


        Instant fin = Instant.now();
        System.out.println("Tiempo[" + (inicio.until(fin, ChronoUnit.MILLIS)) + "]");


/*
        ForkJoinPool piscinaFJ = new ForkJoinPool();

        TareaEncuentraMax action = new TareaEncuentraMax(data, 0, data.length - 1, data.length / 512);

        inicio = Instant.now();
        max = piscinaFJ.invoke(action);
        fin = Instant.now();
        System.out.println("Tiempo[" + (inicio.until(fin, ChronoUnit.MILLIS)) + "]\n Valor máximo:" + max);
*/

    }
}
