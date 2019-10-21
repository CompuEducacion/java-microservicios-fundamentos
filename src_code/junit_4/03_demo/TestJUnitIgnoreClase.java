import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

@Ignore
public class TestJUnitIgnoreClase {

    String mensaje = "Hola Mundo";
    UtileriaMensajes UtileriaMensajes = new UtileriaMensajes(mensaje);


    @Test
    public void testImprimeMensaje() {
        System.out.println("En testImprimeMensaje()");
        assertEquals(mensaje, UtileriaMensajes.imprimeMensaje());
    }
    

    @Test
    public void testImprimeSaludo() {
        System.out.println("En testImprimeSaludo()");
        assertEquals(mensaje, UtileriaMensajes.imprimeSaludo());
    }

}