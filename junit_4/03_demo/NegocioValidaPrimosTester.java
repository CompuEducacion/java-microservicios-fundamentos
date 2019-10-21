import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NegocioValidaPrimosTester {
   public static void main(String[] args) {
      Result resultado = JUnitCore.runClasses(NegocioValidaPrimosTest.class);

      for (Failure fallo : resultado.getFailures()) {
         System.out.println(fallo.toString());
      }
		
      System.out.println(resultado.wasSuccessful());
   }
} 