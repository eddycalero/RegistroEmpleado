package modell;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoAleatorio {

    private static RandomAccessFile flujo;
    private static int numeroRegistros;
    private static int tamanoRegistro = 100;

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
                flujo.writeBoolean(user.getIsActive());
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
            return new User(flujo.readUTF(), flujo.readUTF(), flujo.readUTF(), flujo.readUTF(), flujo.readUTF(),
                    flujo.readUTF(), flujo.readUTF(), flujo.readBoolean());

        } else {
            System.out.println("Limite no permitido");
            return null;
        }

    }

    public static int buscarRegistro(String buscado) throws IOException {
        String Nombre;
        if (buscado == null) {
            return -1;
        }
        for (int i = 0; i < getNumeroRegistros(); i++) {

            flujo.seek(i * tamanoRegistro);

            Nombre = getUser(i).getNombre();

            if (Nombre.equals(buscado)) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%18s %18s %18s %18s  %18s %18s  %18s", "Nombre", "Cedula","Edad", "Profesion",
                        "Area Laboral", "Contacto", "Direccion");
                        System.out.println();
                System.out.format("%18s %18s %18s %18s  %18s %18s  %18s", getUser(i).getNombre(),
                        getUser(i).getContacto(), getUser(i).getEdad(), getUser(i).getProfesion(),
                        getUser(i).getArea_Laboral(), getUser(i).getCedula(), getUser(i).getDireccion());
                        System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

                return 1;
            }
        }
        return -1;
    }


}
