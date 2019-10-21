package lenguaje;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryConRecursos {

    static String leeArchivo(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static void main(String args[]) {
        try {
            System.out.println(leeArchivo("dato.txt"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
