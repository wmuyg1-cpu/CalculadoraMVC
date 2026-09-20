package vista;

import javax.swing.*;
import java.awt.*;

public class CalculadoraVista extends JFrame {

    private JTextField txtNumero1;
    private JTextField txtNumero2;

    private JComboBox<String> cmbOperacion;

    private JButton btnCalcular;
    private JButton btnLimpiar;

    private JLabel lblResultado;

    public CalculadoraVista() {

        setTitle("Calculadora MVC");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearInterfaz();
    }

    private void crearInterfaz() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Número 1
        panel.add(new JLabel("Número 1:"));

        txtNumero1 = new JTextField();
        panel.add(txtNumero1);

        // Número 2
        panel.add(new JLabel("Número 2:"));

        txtNumero2 = new JTextField();
        panel.add(txtNumero2);

        // Operación
        panel.add(new JLabel("Operación:"));

        cmbOperacion = new JComboBox<>();

        cmbOperacion.addItem("Suma");
        cmbOperacion.addItem("Resta");
        cmbOperacion.addItem("Multiplicación");
        cmbOperacion.addItem("División");

        panel.add(cmbOperacion);

        // Botón calcular
        btnCalcular = new JButton("Calcular");
        panel.add(btnCalcular);

        // Botón limpiar
        btnLimpiar = new JButton("Limpiar");
        panel.add(btnLimpiar);

        // Resultado
        panel.add(new JLabel("Resultado:"));

        lblResultado = new JLabel("0");
        panel.add(lblResultado);

        add(panel);
    }

    public JTextField getTxtNumero1() {
        return txtNumero1;
    }

    public JTextField getTxtNumero2() {
        return txtNumero2;
    }

    public JComboBox<String> getCmbOperacion() {
        return cmbOperacion;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void mostrarResultado(double resultado) {

        lblResultado.setText(String.valueOf(resultado));
    }

    public void mostrarError(String mensaje) {

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void limpiarCampos() {

        txtNumero1.setText("");
        txtNumero2.setText("");

        cmbOperacion.setSelectedIndex(0);

        lblResultado.setText("0");

        txtNumero1.requestFocus();
    }
}