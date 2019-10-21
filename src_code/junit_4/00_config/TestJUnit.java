import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
     @Test
     public void testAdd() {
         String str = "Junit";
         assertEquals("Junit", str);
     }
}
