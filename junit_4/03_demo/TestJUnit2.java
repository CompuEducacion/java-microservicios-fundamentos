import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit2 {

    String mensaje = "Hola Mundo";
    UtileriaMensajes UtileriaMensajes = new UtileriaMensajes("Hola ");

    @Test
    public void testImprimeSaludo() {
        System.out.println("En testImprimeMensaje()");
        assertEquals(mensaje, UtileriaMensajes.imprimeSaludo());
    }
}