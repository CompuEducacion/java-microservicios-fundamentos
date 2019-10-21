/*
 * Esta clase imprime el mensaje en consola
 */

public class UtileriaMensajesExpected {
    private String mensaje;

    // Constructor
    // @param Mensaje a ser impreso
    public UtileriaMensajesExpected(String mensaje) {
        this.mensaje = mensaje;
    }

    // Imprime el mensaje en consola
    // Nota: 1/0 ArithmeticException
    public void imprimeMensaje() {
        System.out.println(mensaje);
        int a = 0;
        int b = 1/a;
    }

}
