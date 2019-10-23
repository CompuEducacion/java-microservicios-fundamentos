package fork_join;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class TestEncuentaMax {
    public static void main(String[] args) {


        //Genera datos
        int[] data = new int[1024 * 1024 * 512]; //1M

        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt();
        }

        Instant inicio = Instant.now();
        int max = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        Instant fin = Instant.now();
        System.out.println("Tiempo[" + (inicio.until(fin, ChronoUnit.MILLIS)) + "]\n Valor máximo:" + max);



        ForkJoinPool piscinaFJ = new ForkJoinPool();

        TareaEncuentraMax action = new TareaEncuentraMax(data, 0, data.length - 1, data.length / 512);

        inicio = Instant.now();
        max = piscinaFJ.invoke(action);
        fin = Instant.now();
        System.out.println("Tiempo[" + (inicio.until(fin, ChronoUnit.MILLIS)) + "]\n Valor máximo:" + max);

    }
}
