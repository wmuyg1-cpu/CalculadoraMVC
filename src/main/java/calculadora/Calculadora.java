package calculadora;

import controlador.CalculadoraControlador;
import modelo.CalculadoraModelo;
import vista.CalculadoraVista;

import javax.swing.SwingUtilities;

public class Calculadora {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CalculadoraModelo modelo =
                    new CalculadoraModelo();

            CalculadoraVista vista =
                    new CalculadoraVista();

            new CalculadoraControlador(
                    modelo,
                    vista
            );

            vista.setVisible(true);
        });
    }
}