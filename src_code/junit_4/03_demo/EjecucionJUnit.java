import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class EjecucionJUnit {

    // Una sola ejecución, al inicio
    @BeforeClass
    public static void antesDeLaClase() {
        System.out.println("Antes de la clase");
    }

    // Una sola ejecución, al final
    @AfterClass
    public static void despuesDeLaClase() {
        System.out.println("Después de la clase");
    }

    // ANTES de la ejecución de cada prueba
    @Before
    public void antesCadaTest() {
        System.out.println("Antes de cada prueba");
    }

    // DESPUÉS de la ejecución de cada prueba
    @After
    public void despuesCadaTest() {
        System.out.println("Después de cada prueba");
    }

    // Caso de prueba 1
    @Test
    public void casoPrueba1() {
        System.out.println("Caso De Prueba 1");
    }

    // Caso de prueba 2
    @Test
    public void casoPrueba2() {
        System.out.println("Caso De Prueba 2");
    }
}