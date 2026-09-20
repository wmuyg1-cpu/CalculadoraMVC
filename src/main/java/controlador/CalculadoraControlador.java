package controlador;

import modelo.CalculadoraModelo;
import vista.CalculadoraVista;

public class CalculadoraControlador {

    private CalculadoraModelo modelo;
    private CalculadoraVista vista;

    public CalculadoraControlador(
            CalculadoraModelo modelo,
            CalculadoraVista vista) {

        this.modelo = modelo;
        this.vista = vista;

        iniciarEventos();
    }

    private void iniciarEventos() {

        vista.getBtnCalcular().addActionListener(e -> calcular());

        vista.getBtnLimpiar().addActionListener(e -> limpiar());
    }

    private void calcular() {

        try {

            double numero1 = Double.parseDouble(
                    vista.getTxtNumero1().getText()
            );

            double numero2 = Double.parseDouble(
                    vista.getTxtNumero2().getText()
            );

            String operacion =
                    (String) vista.getCmbOperacion().getSelectedItem();

            double resultado;

            switch (operacion) {

                case "Suma":
                    resultado = modelo.sumar(numero1, numero2);
                    break;

                case "Resta":
                    resultado = modelo.restar(numero1, numero2);
                    break;

                case "Multiplicación":
                    resultado = modelo.multiplicar(numero1, numero2);
                    break;

                case "División":
                    resultado = modelo.dividir(numero1, numero2);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Operación no válida."
                    );
            }

            vista.mostrarResultado(resultado);

        } catch (NumberFormatException e) {

            vista.mostrarError(
                    "Debe ingresar números válidos."
            );

        } catch (IllegalArgumentException e) {

            vista.mostrarError(
                    e.getMessage()
            );
        }
    }

    private void limpiar() {

        vista.limpiarCampos();
    }
}