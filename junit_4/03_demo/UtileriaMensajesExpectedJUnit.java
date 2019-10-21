import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UtileriaMensajesExpectedJUnit {

    String mensaje = "Hola Mundo";
    UtileriaMensajesExpected utileriaMensajes = new UtileriaMensajesExpected(mensaje);

    @Test(expected = ArithmeticException.class)
    public void testImprimeMensaje() {
        System.out.println("En testImprimeMensaje()");
        utileriaMensajes.imprimeMensaje();
    }
}