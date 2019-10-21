import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

    String mensaje = "Hola Mundo";
    UtileriaMensajes UtileriaMensajes = new UtileriaMensajes(mensaje);

    @Test
    public void testImprimeMensaje() {
        assertEquals(mensaje, UtileriaMensajes.imprimeMensaje());
    }
}