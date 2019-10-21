import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestEmpleadoSvc {
    EmpleadoSvc empSvc = new EmpleadoSvc();
    Empleado e = new Empleado();

    // Probar el calculo del bono
    @Test
    public void testCalculateAppriasal() {
        e.setNombre("Juan");
        e.setEdad(25);
        e.setSalarioMensual(8000);
        double bono = empSvc.calculaBono(e);
        assertEquals(500, bono, 0.0);
    }

    // Probar el salario anual
    @Test
    public void testCalculateYearlySalary() {
        e.setNombre("Juan");
        e.setEdad(25);
        e.setSalarioMensual(8000);

        double salarioAnual = empSvc.calculaSalarioAnual(e);
        assertEquals(96000, salarioAnual, 0.0);
    }
}