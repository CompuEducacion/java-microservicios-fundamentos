import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJUnitIgnoreMetodo {

    String mensaje = "Hola Mundo";
    UtileriaMensajes UtileriaMensajes = new UtileriaMensajes(mensaje);


    @Test
    public void testImprimeMensaje() {
        System.out.println("En testImprimeMensaje()");
        assertEquals(mensaje, UtileriaMensajes.imprimeMensaje());
    }
    
    @Ignore
    @Test
    public void testImprimeSaludo() {
        System.out.println("En testImprimeSaludo()");
        assertEquals(mensaje, UtileriaMensajes.imprimeSaludo());
    }

}