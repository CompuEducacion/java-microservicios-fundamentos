
public class NegocioValidaPrimos {

    public Boolean validaPrimo(final Integer numeroPrimo) {
        for (int i = 2; i < (numeroPrimo / 2); i++) {
            if (numeroPrimo % i == 0) {
                return false;
            }
        }
        return true;
    }
}