/*
 * Esta clase imprime el mensaje en consola
 */

public class UtileriaMensajes {
    private String mensaje;

    // Constructor
    // @param Mensaje a ser impreso
    public UtileriaMensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    // Imprime el mensaje en consola
    public String imprimeMensaje() {
        System.out.println(mensaje);
        return mensaje;
    }
    // Imprime un saludo concatenando el mensaje en consola
    public String imprimeSaludo() {
        System.out.println("Hola " + mensaje);
        return mensaje;
    }
}
