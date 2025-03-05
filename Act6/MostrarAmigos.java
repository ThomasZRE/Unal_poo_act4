package Act6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

import javax.swing.JOptionPane;

public class MostrarAmigos {

	public String displayContact() {
		try {
			// Objeto archivo desde el que se va a leer
			// Path usado al ejecutarse desde Actividad4/
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {

				// Crea el archivo de no existir
				file.createNewFile();
			}

			// Abre el archivo en modo lectura
			RandomAccessFile raf = new RandomAccessFile(file, "r");

			// Verificamos si el archivo está vacío
			if (raf.length() == 0) {
                raf.close();
                return "No hay contactos registrados";
            }

			StringBuilder listaContactos = new StringBuilder();
			String line;	
			int count = 0; // Contamos los contactos

			// Recorre el archivo para leer cada linea

			while ((line = raf.readLine()) != null) {
				if (line.contains("!")) {
					String[] parts = line.split("!");
					if (parts.length == 2) {
						listaContactos.append("Nombre: ").append(parts[0]).append(", Número: ").append(parts[1]).append("\n");
						count++;
					}
				}
			}

			// Cierra el archivo
			raf.close();
				
			JOptionPane.showMessageDialog(null, listaContactos.toString(), "Lista de contactos (" + count + ")", JOptionPane.INFORMATION_MESSAGE);
			
			return "Se encontraron " + count + " contactos"; 
		}

		catch (IOException ioe) {
			return "Error al leer contactos: " + ioe.getMessage();
		}
	    catch (Exception e) {
			return "Error inesperado: " + e.getMessage();
		}	
    }

}
		