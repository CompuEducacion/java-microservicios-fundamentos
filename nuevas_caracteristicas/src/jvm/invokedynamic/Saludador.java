package jvm.invokedynamic;

public class Saludador {

    public String cadena;

    public void saludaSimple() {
        System.out.println("saludaSimple");
    }

    public static void saludaStatic() {
        System.out.println("saludaStatic");
    }

    public void saludaParametro(String _p) {
        System.out.println("saludaParametro: " + _p);
    }

    public String obtenMensajeSaludoParam(String _p) {
        return "obtenMensajeSaludoParam: " + _p;
    }
}
