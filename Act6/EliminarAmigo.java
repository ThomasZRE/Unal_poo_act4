package Act6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

class EliminarAmigo {
    private String nombre;
    private Long numero;

    public EliminarAmigo(String nombre, Long numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String deleteContact() {
        try {
            // Archivo del cual se va a leer y modificar
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {
				return "No existe el archivo";
			}

            // Abre en modo lectura y escritura
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
            List<String> contacts = new ArrayList<>();
            String line;

            while ((line = raf.readLine()) != null) {
                contacts.add(line);
            }

            raf.close();

            // Archivo temporal
            File tmpFile = new File("temp.txt");

            // Abre el archivo en modo lectura y escritura
            RandomAccessFile rafTemp = new RandomAccessFile(tmpFile, "rw");

            boolean found = false;

			// Verifica si el cnotacto existe
			for (String contact : contacts) {
                if (contact.contains("!")) {
                    String[] parts = contact.split("!");
                    if (parts.length == 2) {
                        String currentName = parts[0];
                        Long currentNumber = null;
                        
                        try {
                            currentNumber = Long.parseLong(parts[1]);
                        } catch (NumberFormatException e) {
                            // Skip invalid entries
                            rafTemp.writeBytes(contact + System.lineSeparator());
                            continue;
                        }
                        
                        // Check if this is the contact to delete
                        boolean matchesName = nombre != null && !nombre.trim().isEmpty() && 
                                              currentName.equals(nombre);
                        boolean matchesNumber = numero != null && currentNumber.equals(numero);
                        
                        // Delete if matches either name or number (or both)
                        if (matchesName || matchesNumber) {
                            found = true;
                            // Skip this contact (don't write it)
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

            if (file.delete() && tmpFile.renameTo(file)) {
                if (found) {
                    return "Contacto eliminado exitosamente";
                } else {
                    return "No se encontró el contacto a eliminar";
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