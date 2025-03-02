// Move to the same directory as the java file and run
// java -cp ..\. Act6.MostrarAmigo
// or from Actividad4/ run
// java Act6.MostrarAmigos

// TODO: change comments

package Act6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class MostrarAmigos {
	public static void main(String args[]) {
		try {

			String nombreNumeroString;
			String nombre;
			long numero;
			//int index;

			// Objeto archivo desde el que se va a leer
            // Path usado al ejecutarse desde Actividad4/
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {

				// Crea el archivo de no existir
				file.createNewFile();
			}

			// Abre el archivo en modo lectura
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			//boolean found = false;

			// Recorre el archivo para leer cada linea
			while (raf.getFilePointer() < raf.length()) {

				// Guarda cada linea
				nombreNumeroString = raf.readLine();

				// Saca el nombre y numero por separados
				String[] lineSplit = nombreNumeroString.split("!");

				// Separa nombre y numero en variables distintas
				nombre = lineSplit[0];
				numero = Long.parseLong(lineSplit[1]);

				// Muestra en pantalla los contactos
				System.out.println("Nombre del contacto: " + nombre + "\n" + "Numero de contacto: " + numero + "\n");
			}
        }

		catch (IOException ioe) {
				System.out.println(ioe);
			}
	    catch (NumberFormatException nef) {
				System.out.println(nef);
			}
        }
}