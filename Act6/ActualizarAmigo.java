// run with java Act6.MostrarAmigo
// TODO: Fix update bug


package Act6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

public class ActualizarAmigo {

	public static void main(String args[])
	{
		try {

			// Guarda el nombre del contacto a modificar
			String nombreContacto = args[0];

			// Guarda el numero a actualizar
			long numeroNuevo = Long.parseLong(args[1]);

			String nombreNumeroString; // Guarda cada registro durante la lectura
			String nombre;      // Guarda el nombre del registro
			long numero;        // Guarda el numero del registro
			int index;          // Ubica la posición del separador "!"

			// Objeto File para el archivo a leer y modificar
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Abre en modo lectura y escritura
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;  // Registra si el contacto ingresado está en la lista


            // Verificamos que el nombre o numero existe
			while (raf.getFilePointer() < raf.length()) {

				// Lee cada linea
				nombreNumeroString = raf.readLine();

				// Separa la linea registrada
				String[] lineSplit = nombreNumeroString.split("!");

				// Separa nombre y numero en variables
				nombre = lineSplit[0];
				numero = Long.parseLong(lineSplit[1]);

				// Condicion de existencia
				if (nombre.equals(nombreContacto) || numero == numeroNuevo) {
					found = true;
					break;
				}
			}

			// Actualiza el contacto si ya existe
			if (found == true) {

				// Creamos un archivo temporal
				File tmpFile = new File("./Act6/temp.txt");

				// En modo lectura y escritura
				RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

				// Ajustamos el puntero al comienzo (0)
				raf.seek(0);

				// Leemos el arhcivo
				while (raf.getFilePointer() < raf.length()) {

					// Lee cada contacto
					nombreNumeroString = raf.readLine();

					index = nombreNumeroString.indexOf('!');
					nombre = nombreNumeroString.substring(0, index);

					// Verifica que sea el contacto a actualizar
					if (nombre.equals(nombreContacto)) {
						// Actualiza el numero del contacto seleccionado
						nombreNumeroString = nombre + "!" + String.valueOf(numeroNuevo);
					}

					// Agregamos el contacto al archivo temporal
					tmpraf.writeBytes(nombreNumeroString);

					// Agrega el salto de linea
					tmpraf.writeBytes(System.lineSeparator());
				}

                // Ya actualizamos el contacto
				// entonces copiamos el contenido del
				// archivo temporal al archivo original
				
				// Ajustamos ambos punteros al inicio nuevamente
				raf.seek(0);
				tmpraf.seek(0);

				// Copiamos del temporal al original
                // raf: original   |    tmpraf: temporal
				while (tmpraf.getFilePointer() < tmpraf.length()) {
					raf.writeBytes(tmpraf.readLine());
					raf.writeBytes(System.lineSeparator());
				}

                // Ajustamos la longitud del archivo 
                // original al del temporal
				raf.setLength(tmpraf.length());

				// Cerramos los archivos
				tmpraf.close();
				raf.close();

				// Eliminamos el archivo temporal
				tmpFile.delete();

                // Operacion exitosa
				System.out.println(" Contacto actualizado. ");
			}

			// De no ser encontrado
			else {
				// Cerramos el archivo
				raf.close();

				// Mensaje de error
				System.out.println(" Contacto" + " no existe. ");
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
