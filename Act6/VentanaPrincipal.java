package Act6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container container;

    // Labels para nombre y apellidos
    JLabel nombre, numero, resultado;

    // Campos de texto respectivos
    JTextField nombreField, numeroField;

    // Botones
    JButton create, read, update, delete;

    public VentanaPrincipal() {
        inicio();
        setTitle("Configurar contacto");
        setSize(450,270); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        container = getContentPane();
        container.setLayout(null);


        /*  Nombre */
        // Posicion del label nombre
        nombre = new JLabel();
        nombre.setText("Nombre ");
        nombre.setBounds(20, 20, 135, 23); 

        // Posicion del campo para el nombre
        nombreField = new JTextField();
        nombreField.setBounds(105, 20, 135, 23);


        /*  Numero */
        // Posicion label numero
        numero = new JLabel();
        numero.setText("Número ");
        numero.setBounds(20, 50, 135, 23);

        // posicion campo nombre
        numeroField = new JTextField();
        numeroField.setBounds(105, 50, 135, 23);


        /* Resultado */
        resultado = new JLabel();
        resultado.setBounds(40,150, 360, 23);
        
        /*  Botones */
        create = new JButton();
        create.setText("Add");
        create.setBounds(40, 110, 80, 23);
        create.addActionListener(this);

        read = new JButton();
        read.setText("Display");
        read.setBounds(140, 110, 80, 23);
        read.addActionListener(this);

        update = new JButton();
        update.setText("Update");
        update.setBounds(240, 110, 80, 23);
        update.addActionListener(this);

        delete = new JButton();
        delete.setText("Delete");
        delete.setBounds(340, 110, 80, 23);
        delete.addActionListener(this);


        // Se agrega a la ventana
        container.add(nombre);
        container.add(nombreField);
        container.add(numero);
        container.add(numeroField);
        container.add(create);
        container.add(read);
        container.add(update);
        container.add(delete);
        container.add(resultado);
    
    }

    // @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == create) {
            createContact();
        }
        if (e.getSource() == read) {
            readContact();
        }
        if (e.getSource() == update) {
            updateContact();
        }
        if (e.getSource() == delete) {
            deleteContact();
        }
    }

    public void createContact() {
        try {
            String name = nombreField.getText();
            String numtext = numeroField.getText();
        
            // Valida la entrada
            if (name.trim().isEmpty()) {
                resultado.setText("Error: El nombre no puede estar vacío");
                return;
            }
            
            if (numtext.trim().isEmpty()) {
                resultado.setText("Error: El número no puede estar vacío");
                return;
            }

            Long num;
            try {
                num = Long.parseLong(numtext);
            } catch (NumberFormatException e) {
                resultado.setText("Error: Número inválido");
                return;
            }
    
            AgregarAmigo A = new AgregarAmigo();
            A.setnombreNuevo(nombreField.getText());
            A.setnumeroNuevo(Long.parseLong(numeroField.getText()));
            String result = A.createContact();
            resultado.setText(result);

            // Limpia los campos en caso de exito
            if (result.startsWith("Amigo agregado")) {
                nombreField.setText("");
                numeroField.setText("");
            }

        }
        catch (Exception e) {
            resultado.setText("Error: " + e.getMessage());
        }


    }
    public void readContact() {
        


        MostrarAmigos M = new MostrarAmigos();
        M.displayContact();
        resultado.setText("");
    }
    public void updateContact() {
        ActualizarAmigo U = new ActualizarAmigo(nombreField.getText(),Long.parseLong(numeroField.getText()));
        U.updateContact();
        resultado.setText(" Contacto actualizado. ");

    }
    public void deleteContact() {
        EliminarAmigo E = new EliminarAmigo(nombreField.getText(),Long.parseLong(numeroField.getText()));
        E.deleteContact();
        resultado.setText(" Contacto eliminado. ");
    }
}
