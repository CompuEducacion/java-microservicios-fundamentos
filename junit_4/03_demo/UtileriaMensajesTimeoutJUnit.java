import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UtileriaMensajesTimeoutJUnit {

    String mensaje = "Hola Mundo";
    UtileriaMensajesTimeout utileriaMensajesTimeout = new UtileriaMensajesTimeout(mensaje);

    @Test(timeout = 1000)
    public void testImprimeMensaje() {
        System.out.println("En testImprimeMensaje()");
        utileriaMensajesTimeout.imprimeMensaje();
    }
}