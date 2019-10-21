import junit.framework.*;

public class JUnitTestSuite {
    public static void main(String[] a) {
        // Agrega los casos a la suite
        TestSuite suite = new TestSuite(TestAPIJUnit1.class, TestAPIJUnit2.class, TestAPIJUnit3.class);
        TestResult resultado = new TestResult();
        suite.run(resultado);
        System.out.println("Cantidad de casos de prueba: " + resultado.runCount());
    }
}