
public class EmpleadoSvc {
    // Calcula el salario anual
    public double calculaSalarioAnual(Empleado e) {
        double salarioAnual = 0.0;
        salarioAnual = e.getSalarioMensual() * 12;
        return salarioAnual;
    }

    // Calcular bono
    public double calculaBono(Empleado e) {
        double bono = 0;

        if (e.getSalarioMensual() < 10000) {
            bono = 500;
        } else {
            bono = 1000;
        }
        return bono;
    }
}