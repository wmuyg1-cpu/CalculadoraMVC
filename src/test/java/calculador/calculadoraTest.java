package calculador;

import modelo.CalculadoraModelo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class calculadoraTest {

    private CalculadoraModelo calculadora;

    @Before
    public void before() {

        calculadora = new CalculadoraModelo();
    }

    @Test
    public void testSumar() {

        double resultado = calculadora.sumar(10, 5);

        assertEquals(15.0, resultado, 0.0);
    }

    @Test
    public void testRestar() {

        double resultado = calculadora.restar(10, 5);

        assertEquals(5.0, resultado, 0.0);
    }

    @Test
    public void testMultiplicar() {

        double resultado = calculadora.multiplicar(10, 5);

        assertEquals(50.0, resultado, 0.0);
    }

    @Test
    public void testDividir() {

        double resultado = calculadora.dividir(10, 5);

        assertEquals(2.0, resultado, 0.0);
    }

    @Test
    public void testDividirEntreCero() {

        try {

            calculadora.dividir(10, 0);

            fail("Se esperaba una excepción.");

        } catch (IllegalArgumentException e) {

            assertEquals(
                    "No se puede dividir entre cero.",
                    e.getMessage()
            );
        }
    }
}