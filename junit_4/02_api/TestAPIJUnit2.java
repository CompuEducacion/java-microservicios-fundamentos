import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestAPIJUnit2 extends TestCase {
    protected double valor1;
    protected double valor2;

    // setUp para cargar/configurar recursos
    @Before
    public void setUp() {
        System.out.println("setUp");
        valor1 = 2.0;
        valor2 = 3.0;
    }

    @Test
    public void testAdd() {
        // Cantidad de casos de prueba
        System.out.println("# de casos de prueba: " + this.countTestCases());

        // Obtiene el nombre del caso de prueba
        String nombre = this.getName();
        System.out.println("Nombre del caso de prueba: " + nombre);

        // Asigna el nombre del caso de prueba
        this.setName("nuevoNombreCasoPrueba");
        String nuevoNombre = this.getName();
        System.out.println("Nombre (actualizado) del caso de prueba:  = " + nuevoNombre);
    }

    // tearDown para liberar recursos
    public void tearDown() {
        System.out.println("tearDown");
    }
}