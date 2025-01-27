package persona;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private ListaPersonas lista; // Objeto ListaPersonas
    private Container contenedor; // Contenedor para los graficos
    
    // Labels para los atributos 
    private JLabel nombre, apellidos, teléfono, dirección;

    // Textfields respectivos
    private JTextField campoNombre, campoApellidos, campoTeléfono,
    campoDirección;

    private JButton añadir, eliminar, borrarLista; // Botones
    
    private JList listaNombres; // Lista de personas
    
    private DefaultListModel modelo; // Modelo de la lista (Objeto)
    
    private JScrollPane scrollLista; // Barra scroll

    public VentanaPrincipal() {
        lista = new ListaPersonas();
        inicio();
        setTitle("Personas"); 
        setSize(270,350); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null);

        nombre = new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(20, 20, 135, 23); 
        
        campoNombre = new JTextField();
        campoNombre.setBounds(105, 20, 135, 23);
        
        // Establece la etiqueta y el campo apellidos
        apellidos = new JLabel();
        apellidos.setText("Apellidos:"); /* Establece la posición de la
        etiqueta apellidos */
        apellidos.setBounds(20, 50, 135, 23);
        
        campoApellidos = new JTextField();
        campoApellidos.setBounds(105, 50, 135, 23); // Posicion texto apellidos
        
        // Label para telefono
        teléfono = new JLabel();
        teléfono.setText("Teléfono:");
        teléfono.setBounds(20, 80, 135, 23); // Posicion telefono

        campoTeléfono = new JTextField(); // textfield respectivo
        campoTeléfono.setBounds(105, 80, 135, 23);
        
        // Label para direccion
        dirección = new JLabel();
        dirección.setText("Dirección:");
        dirección.setBounds(20, 110, 135, 23); // Posicion direccion

        campoDirección = new JTextField(); // Textfield direccion
        campoDirección.setBounds(105, 110, 135, 23);
        
        // Boton añadir
        añadir = new JButton();
        añadir.setText("Añadir");
        añadir.setBounds(105, 150, 80, 23); // Posicion añadir
        añadir.addActionListener(this); // Action listener para el boton

        // Boton eliminar
        eliminar= new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(20, 280, 80, 23); // Posicion eliminar
        eliminar.addActionListener(this); // Actionlistener
        
        // Boton Borrar lista
        borrarLista= new JButton();
        borrarLista.setText("Borrar Lista");
        borrarLista.setBounds(120, 280, 120, 23); // Posicion borrar
        borrarLista.addActionListener(this); // Actionlistener respectivo
        
        // Lista grafica personas
        listaNombres = new JList();
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selecciona solo un elemento

        modelo = new DefaultListModel();
        
        // Nueva barra scroll
        scrollLista = new JScrollPane();
        scrollLista.setBounds(20, 190 ,220, 80); // pos desplazamiento vertical
        scrollLista.setViewportView(listaNombres); // Asocia a lista personas
        
        // Agrega todo a la ventana
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(teléfono);
        contenedor.add(campoTeléfono);
        contenedor.add(dirección);
        contenedor.add(campoDirección);
        contenedor.add(añadir);
        contenedor.add(eliminar);
        contenedor.add(borrarLista);
        contenedor.add(scrollLista);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == añadir) {
            añadirPersona();
        }
        if (e.getSource() == eliminar) {
            eliminarNombre(listaNombres.getSelectedIndex());
        }
        if (e.getSource() == borrarLista) {
            borrarLista();
        }
    }

    private void añadirPersona() {
        // Nueva persona
        Persona p = new Persona(campoNombre.getText(), campoApellidos.getText(), campoTeléfono.getText(), campoDirección.getText());
        lista.añadirPersona(p); // Añade la persona
        String elemento = campoNombre.getText() + "-" + campoApellidos.getText() + "-" + campoTeléfono.getText() + "-" + campoDirección.getText();
        modelo.addElement(elemento); // Añade el texto
        listaNombres.setModel(modelo);

        // Para textfields vacios
        campoNombre.setText("");
        campoApellidos.setText("");
        campoTeléfono.setText("");
        campoDirección.setText("");
    }

    private void eliminarNombre(int indice) {
        if (indice >= 0) {
            modelo.removeElementAt(indice);
            lista.eliminarPersona(indice);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarLista() {
        lista.borrarLista();
        modelo.clear();
    }
}
