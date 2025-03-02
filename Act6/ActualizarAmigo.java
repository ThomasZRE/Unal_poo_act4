// run with java Act6.MostrarAmigo
// TODO: Fix update bug


package Act6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

public class ActualizarAmigo {
    private String nombreContacto;
    private Long numeroNuevo;

    public ActualizarAmigo(String nombreContacto, Long numeroNuevo) {
        this.nombreContacto = nombreContacto;
        this.numeroNuevo = numeroNuevo;
    }

    public String updateContact() {
        try {
            // Objeto File para el archivo a leer y modificar
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {

				// Create a new file if not exists.
				return "No existe el archivo";
			}

            // Abre en modo lectura y escritura
			RandomAccessFile raf = new RandomAccessFile(file, "r");
            
            List<String> contacts = new ArrayList<>();
            String line;
            boolean found = false;

            // Verificamos que el nombre o numero existe
			while ((line = raf.readLine()) != null) {

                contacts.add(line);
            }

            raf.close();

            // Abrimos un archivo temporal
            File tmpFile = new File("./Act6/temp.txt");
            RandomAccessFile rafTemp = new RandomAccessFile(tmpFile, "rw");

            for (String contact: contacts) {
                if (contact.contains("!")) {
                    String[] parts = contact.split("!");
                    if (parts.length == 2) {
                        String currentName = parts[0];
    
                        if (currentName.equals(nombreContacto)) {
                            rafTemp.writeBytes(nombreContacto + "!" + numeroNuevo + System.lineSeparator());
                            found = true;
                        } else {
                            rafTemp.writeBytes(contact + System.lineSeparator());
                        } 
                    } else {
                        rafTemp.writeBytes(contact + System.lineSeparator());       
                    }
                } else {
                    rafTemp.writeBytes(contact + System.lineSeparator());
                }
            }

            rafTemp.close();

            // Condicion de existencia
            if (file.delete() && tmpFile.renameTo(file)) {
                if (found) {
                    return "Contacto actualizado";
                } else {
                    return "No se ha encontrado el contacto a actualizar";
                }
            } else {
                return "Error al actualizar el archivo";
            }  
        }
        catch (IOException e) {
            return "Error de I/O: " + e.getMessage();
        }
        catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }
}