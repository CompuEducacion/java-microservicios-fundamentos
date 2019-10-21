import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner2 {
    public static void main(String[] args) {
        Result resultado = JUnitCore.runClasses(TestAPIJUnit2.class);

        for (Failure failure : resultado.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(resultado.wasSuccessful());
    }
}