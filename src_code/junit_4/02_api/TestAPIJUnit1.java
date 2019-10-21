import org.junit.Test;
import static org.junit.Assert.*;

public class TestAPIJUnit1 {
    @Test
    public void testApiUno() {
        // datos de prueba
        int num = 5;
        String temp = null;
        String str = "JUnit";

        // valida igualdad
        assertEquals("JUnit", str);

        // valida condición falsa
        assertFalse(num > 6);

        // valida valor no nulo
        assertNotNull(temp);
        // valida valor nulo
        assertNull(temp);

    }
}