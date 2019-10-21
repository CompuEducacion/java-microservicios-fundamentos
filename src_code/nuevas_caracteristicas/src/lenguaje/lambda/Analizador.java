package lenguaje.lambda;

public class Analizador {

    public void muestraCoincidencias(String[] listaCadenas, String cadena, AnalizadorDeCadenas analizador) {
        for (String actual : listaCadenas) {
            if (analizador.analiza(actual, cadena)) {
                System.out.println("Coincidencia: " + actual);
            }
        }
    }
}
