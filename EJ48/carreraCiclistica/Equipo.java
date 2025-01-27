import java.util.*;

public class Equipo {

    private String nombre;
    private String pais;
    private static double totalTiempo;
    Vector listaCiclistas;

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        totalTiempo = 0;
        listaCiclistas = new Vector(); 
    }   

    // Constructor de Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Constructor de Pais
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Metodo para añadir ciclista
    void añadirCiclista(Ciclista cilclista) {
        listaCiclistas.add(cilclista); // Añade al ciclista a la lista de ciclistas
    }

    void listarEquipo() {
        for (int i = 0; i < listaCiclistas.size(); i++) {
            Ciclista c = (Ciclista) listaCiclistas.elementAt(i);
            System.out.println(c.getNombre());
        }
    }


    // Metodo para buscar al ciclista ingresado por teclado
    void buscarCiclista() {
        Scanner scanner = new Scanner(System.in); // Para la entrada por teclado
        
        String nombreCiclista = scanner.nextLine();
        for (int i = 0; i < listaCiclistas.size(); i++) {
            Ciclista c = (Ciclista) listaCiclistas.elementAt(i);

            if (c.getNombre().equals(nombreCiclista)) {
                System.out.println(c.getNombre());
            }
        }
    }

    // Metodo para calcular el tiempo total de un equipo
    void calculartotalTiempo() {
        for (int i = 0; i < listaCiclistas.size(); i++) {
            Ciclista c = (Ciclista) listaCiclistas.elementAt(i);
            totalTiempo = totalTiempo + c.getTiempoAcumulado();
        }
    }


    // Metodo para mostrar los datos en pantalla
    void mostrar() {
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("Total tiempo del equipo: " + totalTiempo);
    }

}
