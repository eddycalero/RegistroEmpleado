package modell;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {
    
    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static int tamanoRegistro = 300;

    public static void crearFileUser(File archivo) throws IOException {
        if (archivo.exists() && !archivo.isFile()) {
            throw new IOException(archivo.getName() + " no es un archivo");
        }
        flujo = new RandomAccessFile(archivo, "rw");
        numeroRegistros = (int) Math.ceil(
                (double) flujo.length() / (double) tamanoRegistro);
    }

    public static void cerrar() throws IOException {
        flujo.close();
    }

    public static boolean setUser(int i, User user) throws IOException {
        if (i >= 0 && i <= getNumeroRegistros()) {
            if (user.getTamano() > tamanoRegistro) {
            } else {
                flujo.seek(i * tamanoRegistro);
                flujo.writeUTF(user.getNombre());
                flujo.writeUTF(user.getCedula());
                flujo.writeUTF(user.getEdad());
                flujo.writeUTF(user.getProfesion());
                flujo.writeUTF(user.getArea_Laboral());
                flujo.writeUTF(user.getContacto());
                flujo.writeUTF(user.getDireccion());
                return true;

            }
        } else {

        }

        return false;
    }

    public static void CrearUser(User user) throws IOException {
        if (setUser(numeroRegistros, user)) {
            numeroRegistros++;
        }
    }

    public static int getNumeroRegistros() {
        return numeroRegistros;
    }

    public static User getUser(int i) throws IOException {
        if (i >= 0 && i <= getNumeroRegistros()) {
            flujo.seek(i * tamanoRegistro);
            // return new User(flujo.readUTF(), flujo.readUTF());
            User a = new User();
            a.setNombre(flujo.readUTF());
            a.setCedula(flujo.readUTF());
            return a;
        } else {
            return null;
        }

    }

    public static int buscarRegistro(String buscado, String cedula) throws IOException {
        String Nombre;
        String Cedula;
        if (buscado == null && cedula == null) {
            return -1;
        }
        for (int i = 0; i < getNumeroRegistros(); i++) {
            flujo.seek(i * tamanoRegistro);
            Nombre = getUser(i).getCedula();
            Cedula = getUser(i).getNombre();

            if (Nombre.equals(buscado) && Cedula.equals(cedula)) {
                return 1;
            }
        }
        return -1;
    }
}
