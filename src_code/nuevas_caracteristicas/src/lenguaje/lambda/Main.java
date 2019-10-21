package lenguaje.lambda;

public class Main {

    public static void main(String[] args) {
        String[] listaCadenas
                = {"violeta", "azul", "celeste", "verde", "amarillo", "naranja", "rojo"};

        Analizador analizador = new Analizador();
        String cadena = "a";

        System.out.println("Buscando: " + cadena);

        System.out.println("Contiene");
        analizador.muestraCoincidencias(listaCadenas, cadena, (t, s) -> t.contains(s));

        System.out.println("Inicia con");
        analizador.muestraCoincidencias(listaCadenas, cadena, (t, s) -> t.startsWith(s));

        System.out.println("Termina con");
        //TO-DO

        System.out.println("Menor que 7");
        //TO-DO
    }
}
