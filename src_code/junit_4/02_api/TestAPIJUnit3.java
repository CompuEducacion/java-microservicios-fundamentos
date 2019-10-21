import org.junit.Test;
import junit.framework.AssertionFailedError;
import junit.framework.TestResult;

public class TestAPIJUnit3 extends TestResult {
    // adiciona un error
    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test) test, t);
    }

    // agrega un fallo
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((junit.framework.Test) test, t);
    }

    @Test
    public void testAdd() {
        // pruebas
    }

    // Marca que la prueba debe detenerse
    public synchronized void stop() {
        // 
    }
}