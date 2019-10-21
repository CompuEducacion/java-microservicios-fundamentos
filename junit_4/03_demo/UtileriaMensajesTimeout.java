/*
 * Esta clase imprime el mensaje en consola
 */

public class UtileriaMensajesTimeout {
    private String mensaje;

    // Constructor
    // @param Mensaje a ser impreso
    public UtileriaMensajesTimeout(String mensaje) {
        this.mensaje = mensaje;
    }

    // Imprime el mensaje en consola
    // Nota: El ciclo while no termina
    public void imprimeMensaje() {
        System.out.println(mensaje);
        while(true);
    }

}
