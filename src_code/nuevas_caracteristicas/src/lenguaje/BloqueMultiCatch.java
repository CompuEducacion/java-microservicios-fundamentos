package lenguaje;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class BloqueMultiCatch {

    static void transfiereArchivo() throws FileNotFoundException, UnknownHostException {
        boolean encontrado = true;
        try {
            if (encontrado == false) {
                throw new FileNotFoundException();
            } else {
                throw new UnknownHostException();
            }
        } catch (final IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        //TO-DO
    }
}
