import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit1 {

    String mensaje = "Hola Mundo";
    UtileriaMensajes UtileriaMensajes = new UtileriaMensajes(mensaje);

    @Test
    public void testImprimeMensaje() {
        System.out.println("En testImprimeMensaje()");
        assertEquals(mensaje, UtileriaMensajes.imprimeMensaje());
    }
}