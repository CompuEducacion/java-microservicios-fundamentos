import java.util.Objects;

public class Empleado {
    private String nombre;
    private int edad;
    private double salarioMensual;


    public Empleado() {
    }

    public Empleado(String nombre, int edad, double salarioMensual) {
        this.nombre = nombre;
        this.edad = edad;
        this.salarioMensual = salarioMensual;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalarioMensual() {
        return this.salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public Empleado nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Empleado edad(int edad) {
        this.edad = edad;
        return this;
    }

    public Empleado salarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombre, empleado.nombre) && edad == empleado.edad && salarioMensual == empleado.salarioMensual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, salarioMensual);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            ", salarioMensual='" + getSalarioMensual() + "'" +
            "}";
    }
    

}