// run with java Act6.EliminarAmigo

package Act6;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class EliminarAmigo {
    private String nombreContacto;
    private Long numeroNuevo;

    public EliminarAmigo(String nombreContacto, Long numeroNuevo) {
        this.nombreContacto = nombreContacto;
        this.numeroNuevo = numeroNuevo;
    }

    public void deleteContact() {
        String nombreNumeroString; // Guarda cada registro durante la lectura
        String nombre;      // Guarda el nombre del registro
        long numero;        // Guarda el numero del registro
        int index;          // Ubica la posición del separador "!"

        try {
            // Archivo del cual se va a leer y modificar
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

            // Abre en modo lectura y escritura
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;

			// Verifica si el cnotacto existe
			while (raf.getFilePointer() < raf.length()) {

				// Lee el archivo
				nombreNumeroString = raf.readLine();

				// Separa la linea
				String[] lineSplit = nombreNumeroString.split("!");

				// Separa el nombre y numero
				nombre = lineSplit[0];
				numero = Long.parseLong(lineSplit[1]);

				// Condicion para el nombre
				if (nombre.equals(nombreContacto)) {
					found = true;
					break;
				}
			}

            // Borra el contacto si se existe en la lista
			if (found == true) {

				// Archivo temporal
				File tmpFile = new File("temp.txt");

				// Abre el archivo en modo lectura y escritura
				RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

				// Ajusta el puntero al comienzo
				raf.seek(0);

				// Lee el archivo original
				while (raf.getFilePointer() < raf.length()) {

					// Lee cada contacto
					nombreNumeroString = raf.readLine();

					index = nombreNumeroString.indexOf('!');
					nombre = nombreNumeroString.substring(
						0, index);

					// Comprueba el contacto a eliminar
					if (nombre.equals(nombreContacto)) {
						continue;
					}

					// Lo agrega al archivo temporal
					tmpraf.writeBytes(nombreNumeroString);

					// Agrega el salto de linea
					tmpraf.writeBytes(
						System.lineSeparator());
				}

                // Ya eliminamos el contacto
				// copiamos el contenido del
				// archivo temporal al archivo original

				// Ajustamos ambos punteros al comienzo
				raf.seek(0);
				tmpraf.seek(0);

				// Copiamos el contenido del temporal al original
				while (tmpraf.getFilePointer() < tmpraf.length()) {
					raf.writeBytes(tmpraf.readLine());
					raf.writeBytes(System.lineSeparator());
				}

                // Ajusta la longitud del archivo original al temporal
				raf.setLength(tmpraf.length());

				// Cierra los archivos
				tmpraf.close();
				raf.close();

				// Borra el archivo temporal
				tmpFile.delete();
                
                // Exitosa
				System.out.println(" Contacto eliminado. ");
			}

            // En caso de no encontrar el contacto a eliminar
			else {

				// Cierra el archivo
				raf.close();

				// Mensaje de error
				System.out.println(" Contacto" + " no existe. ");
			}    
        }

        catch (IOException ioe) {
			System.out.println(ioe);
		}
    }
    /* 
	public static void main(String args[])
	{
		try {
			// Guarda el nombre del contacto a eliminar
			String nombreContacto = args[0];

			String nombreNumeroString;   
			String nombre; 
			long numero;
			int index;

			// Archivo del cual se va a leer y modificar
			File file = new File("./Act6/Contactos.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			// Abre en modo lectura y escritura
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;

			// Verifica si el cnotacto existe
			while (raf.getFilePointer() < raf.length()) {

				// Lee el archivo
				nombreNumeroString = raf.readLine();

				// Separa la linea
				String[] lineSplit = nombreNumeroString.split("!");

				// Separa el nombre y numero
				nombre = lineSplit[0];
				numero = Long.parseLong(lineSplit[1]);

				// Condicion para el nombre
				if (nombre.equals(nombreContacto)) {
					found = true;
					break;
				}
			}

			// Borra el contacto si se existe en la lista
			if (found == true) {

				// Archivo temporal
				File tmpFile = new File("temp.txt");

				// Abre el archivo en modo lectura y escritura
				RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");

				// Ajusta el puntero al comienzo
				raf.seek(0);

				// Lee el archivo original
				while (raf.getFilePointer() < raf.length()) {

					// Lee cada contacto
					nombreNumeroString = raf.readLine();

					index = nombreNumeroString.indexOf('!');
					nombre = nombreNumeroString.substring(
						0, index);

					// Comprueba el contacto a eliminar
					if (nombre.equals(nombreContacto)) {
						continue;
					}

					// Lo agrega al archivo temporal
					tmpraf.writeBytes(nombreNumeroString);

					// Agrega el salto de linea
					tmpraf.writeBytes(
						System.lineSeparator());
				}

                // Ya eliminamos el contacto
				// copiamos el contenido del
				// archivo temporal al archivo original

				// Ajustamos ambos punteros al comienzo
				raf.seek(0);
				tmpraf.seek(0);

				// Copiamos el contenido del temporal al original
				while (tmpraf.getFilePointer() < tmpraf.length()) {
					raf.writeBytes(tmpraf.readLine());
					raf.writeBytes(System.lineSeparator());
				}

                // Ajusta la longitud del archivo original al temporal
				raf.setLength(tmpraf.length());

				// Cierra los archivos
				tmpraf.close();
				raf.close();

				// Borra el archivo temporal
				tmpFile.delete();
                
                // Exitosa
				System.out.println(" Contacto eliminado. ");
			}

			// En caso de no encontrar el contacto a eliminar
			else {

				// Cierra el archivo
				raf.close();

				// Mensaje de error
				System.out.println(" Contacto" + " no existe. ");
			}
		}

		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
        */
}
