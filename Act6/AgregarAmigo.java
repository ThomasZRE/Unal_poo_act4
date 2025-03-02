// To run this file
// move to the same directory as the java file and run
// java -cp ..\. Act6.AgregarAmigo <name> <number>
// or from Actividad4/ run
// java Act6.AgregarAmigo <name> <number>

package Act6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class AgregarAmigo {
    private String nombreNuevo;
    private Long numeroNuevo;

    public String getnombreNuevo() {
        return nombreNuevo;
    }

    public void setnombreNuevo(String nombreNuevo) {
        this.nombreNuevo = nombreNuevo;
    }


    public Long getnumeroNuevo() {
        return numeroNuevo;
    }

    public void setnumeroNuevo(Long numeroNuevo) {
        this.numeroNuevo = numeroNuevo;
    }


    /*
    public AgregarAmigo(String nombreNuevo, Long numeroNuevo) {
        this.nombreNuevo = nombreNuevo;
        this.numeroNuevo = numeroNuevo;
    }
         */

    public String createContact() {
        String nombreNumeroString;
        String nombre;
        long numero;

        try {
            if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) {
                return "Error: el nombre es nulo o vacío";
            }

            if (numeroNuevo == null || numeroNuevo <= 0) {
                return "Error: Número inválido";
            }


            // Objeto file para el archivo donde se guardan los datos
            File file = new File("./Act6/Contactos.txt");

            // Verifica que el archivo exista, crea uno nuevo en caso de que no
            if (!file.exists()) {
                file.createNewFile();
            }

            // Abre el archivo en modo lectura y escritura
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;  // Boooleano para encontrar contacto repetido

            // Verificamos que no se repitan contactos
            // Caso en que se repite
            while (raf.getFilePointer() < raf.length()) {
                nombreNumeroString = raf.readLine();

                // Separa el nombre del numero y lo guarda en un arreglo
                String[] separador = nombreNumeroString.split("!");
                
                // Asigna nombre y numero correspondientes
                nombre = separador[0];
                numero = Long.parseLong(separador[1]);

                // Condicion de repeticion
                if (nombre.equals(nombreNuevo) || numero == numeroNuevo) {
                    found = true;
                    break;
                }
            }

            // Cuando el contacto es nuevo (no se repite)
            if (found == false) {
                nombreNumeroString = nombreNuevo + "!" + String.valueOf(numeroNuevo);

                // Escribimos la secuencia de bytes de la linea guardada
                // al archivo creado
                raf.writeBytes(nombreNumeroString);

                // Separador de linea (Nueva linea)
                raf.writeBytes(System.lineSeparator());

                // Cierra el archivo
                raf.close();

                return " Amigo agregado. ";

            }
            
            else {
                raf.close();
                return "El contacto ya existe";
            }
        } 
        
        catch (IOException ioe) {
            return "Error: " + ioe.getMessage();
        }
        catch ( NumberFormatException nef) {
            return "Error: formato de número inválido";
        }
        catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }
}
