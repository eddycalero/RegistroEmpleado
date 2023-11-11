package modell;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public void MenuOpciones() {
        boolean salir = false;
        System.out.println();
        while (!salir) {

            try {
                System.out.println("***Binevenido**");
                System.out.println("1.Agregar un Empleado");
                System.out.println("2.Buscar un Empleado");
                System.out.println("3.Eliminar un Empleado");
                System.out.println("4.Salir");
                System.out.println("Elige una de las opciones");

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                int opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingresar Nombre del Empleado");
                        String nombre = reader.readLine();
                        System.out.println("Ingresar Cedula");
                        String cedula = reader.readLine();
                        System.out.println("Ingresar Edad");
                        String edad = reader.readLine();
                        System.out.println("Ingresar Profesion");
                        String profesion = reader.readLine();
                        System.out.println("Ingresar el area a laborar");
                        String area_laboral = reader.readLine();
                        System.out.println("Ingresar numero de contacto");
                        String contacto = reader.readLine();
                        System.out.println("Ingresar una Dirección");
                        String direccion = reader.readLine();

                        if (nombre == null && cedula == null && edad == null
                                && profesion == null && area_laboral == null && contacto == null && direccion == null) {
                            System.out.println("Por favor Vuelva a ingresar los datos");
                        }
                        try {
                            AccesoAleatorio.crearFileUser(new File("Empleados.Dat"));
                            AccesoAleatorio.CrearUser(
                                    new User(nombre, cedula, edad, profesion, area_laboral,contacto, direccion, true));
                            AccesoAleatorio.cerrar();
                            System.out.println("Guardado con exito");
                        } catch (IOException ex) {
                            System.err.println(ex.getMessage());
                        }
                        break;
                    case 2:

                        System.out.println("Nombre de la persona a buscar");
                        String nombreBuscar = reader.readLine();

                        try {
                            AccesoAleatorio.crearFileUser(new File("Empleados.Dat"));
                            AccesoAleatorio.buscarRegistro(nombreBuscar);
                           
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }

                        break;
                    case 3:
                        System.out.println("Nombre de la persona a eliminar");
                        String nombreEliminar = reader.readLine();

                        try {
                            AccesoAleatorio.crearFileUser(new File("Empleados.Dat"));
                            if (AccesoAleatorio.eliminarUser(nombreEliminar)) {
                                System.out.println("se borro Correctamente");
                            } else {
                                System.err.println("Error al intertar eliminar el usuario");
                            }

                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }

                        break;
                    case 4:
                        System.out.println("has elegido salir");
                        salir = true;
                        break;

                    default:
                        System.out.println("Elige una opcion entre 1 y 4");
                        break;
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }
}
