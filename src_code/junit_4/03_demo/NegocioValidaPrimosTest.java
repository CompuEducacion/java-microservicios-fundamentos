import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NegocioValidaPrimosTest {
    private Integer numeroEntrada;
    private Boolean resultadoEsperado;
    private NegocioValidaPrimos negocioValidaPrimos;

    @Before
    public void init() {
        negocioValidaPrimos = new NegocioValidaPrimos();
    }

    // Cada parámetro será pasado como un argumento
    // Los datos saldrán del método númerosPrimos
    public NegocioValidaPrimosTest(Integer numeroEntrada, Boolean resultadoEsperado) {
        this.numeroEntrada = numeroEntrada;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameterized.Parameters
    public static Collection numerosPrimos() {
        return Arrays.asList(new Object[][] { { 2, true }, { 6, false }, { 19, true }, { 22, false }, { 23, true } });
    }

    @Test
    public void testValidaPrimo() {
        System.out.println("Parameterized Number is : " + numeroEntrada);
        assertEquals(resultadoEsperado, negocioValidaPrimos.validaPrimo(numeroEntrada));
    }
}