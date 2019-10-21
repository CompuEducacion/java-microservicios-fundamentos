package fork_join;

import java.util.concurrent.RecursiveTask;

public class TareaEncuentraMax extends RecursiveTask<Integer> {

    private final int limite;
    private final int[] datos;
    private int inicio;
    private int fin;

    public TareaEncuentraMax(int[] datos, int inicio, int fin, int limite) {
        this.limite = limite;
        this.datos = datos;
        this.inicio = inicio;
        this.fin = fin;
    }

    protected Integer compute() {
        if (fin - inicio < limite) {
            int max = Integer.MIN_VALUE;
            for (int i = inicio; i <= fin; i++) {
                int n = datos[i];
                if (n > max) {
                    max = n;
                }
            }
            return max;
        } else {
            int mitad = (fin - inicio) / 2 + inicio;
            TareaEncuentraMax a1 = new TareaEncuentraMax(datos, inicio, mitad, limite);
            a1.fork();
            TareaEncuentraMax a2 = new TareaEncuentraMax(datos, mitad + 1, fin, limite);
            return Math.max(a2.compute(), a1.join());
        }
    }
}
