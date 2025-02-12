package Act5.EJ83;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;

    private JLabel base, altura, apotema, volumen, superficie;

    private JTextField BaseField, AlturaField, ApotemaField;

    private JButton calcular;

    public VentanaPiramide() {
        inicio();
        setTitle("Pirámide"); 
        setSize(280,240);

        setLocationRelativeTo(null); 
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null); 

        base = new JLabel();
        base.setText("Base (cms):");
        base.setBounds(20, 20, 135, 23);
        
        BaseField = new JTextField();
        BaseField.setBounds(120, 20, 135, 23);
        
        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        
        AlturaField = new JTextField();
        AlturaField.setBounds(120, 50, 135, 23);
        
        apotema = new JLabel();
        apotema.setText("Apotema (cms):");
        apotema.setBounds(20, 80, 135, 23);

        ApotemaField = new JTextField();
        ApotemaField.setBounds(120, 80, 135, 23);

        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(120, 110, 135, 23);  
        calcular.addActionListener(this);

        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 140, 135, 23);

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 170, 135, 23);

        contenedor.add(base);
        contenedor.add(BaseField);
        contenedor.add(altura);
        contenedor.add(AlturaField);
        contenedor.add(apotema);
        contenedor.add(ApotemaField);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent event) {
        Piramide pirámide;
        boolean error = false;
        double base = 0;
        double altura = 0;
        double apotema = 0;

        try {
            base = Double.parseDouble(BaseField.getText());
            // Se obtiene y convierte el valor numérico de la altura
            altura = Double.parseDouble(AlturaField.getText());
            // Se obtiene y convierte el valor numérico del apotema
            apotema = Double.parseDouble(ApotemaField.getText());
            // Se crea un objeto Pirámide
            pirámide = new Piramide(base, altura, apotema);
            // Se muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f",
            pirámide.calcularVolumen()));
            // Se muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f",
            pirámide.calcularSuperficie()));
        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null,"Campo nulo o error en formato de número", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
    