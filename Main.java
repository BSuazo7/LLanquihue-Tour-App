package app;

import model.Empleado;
import service.RegistroService;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestión Llanquihue Tour.
 * Carga los registros de guías, operadores y proveedores desde un
 * archivo .csv, los almacena en una colección y permite consultarlos
 * por consola (listado completo, búsqueda por RUT y filtrado por cargo).
 */
public class Main {

    public static void main(String[] args) {

        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            // Si falla, se continúa con la codificación por defecto.
        }

        RegistroService registro = new RegistroService();

        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTIÓN - LLANQUIHUE TOUR");
        System.out.println("==========================================\n");

        // 1. Carga de datos desde archivo externo
        System.out.println(">> Cargando datos desde data/personas.csv ...\n");
        registro.cargarDesdeArchivo("data/personas.csv");
        System.out.println();

        // 2. Listado general de todos los registros cargados
        System.out.println("------ LISTADO COMPLETO (" + registro.cantidadRegistrados() + " registros) ------\n");
        registro.listarTodos();

        // 3. Búsqueda por RUT
        System.out.println("------ BÚSQUEDA POR RUT ------");
        String rutBuscado = "15.876.234-5";
        Empleado encontrado = registro.buscarPorRut(rutBuscado);
        if (encontrado != null) {
            System.out.println("Resultado para RUT " + rutBuscado + ":");
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró ningún registro con RUT " + rutBuscado);
        }
        System.out.println();

        // 4. Filtrado por cargo
        System.out.println("------ FILTRO: SOLO GUÍAS ------");
        List<Empleado> guias = registro.filtrarPorCargo("Guía");
        for (Empleado g : guias) {
            System.out.println("- " + g.getNombre() + " " + g.getApellido());
        }
        System.out.println();

        System.out.println("------ FILTRO: SOLO PROVEEDORES ------");
        List<Empleado> proveedores = registro.filtrarPorCargo("Proveedor");
        for (Empleado p : proveedores) {
            System.out.println("- " + p.getNombre() + " " + p.getApellido());
        }
        System.out.println();

        // 5. Filtrado por ciudad
        System.out.println("------ FILTRO: REGISTROS EN PUERTO VARAS ------");
        List<Empleado> enPuertoVaras = registro.filtrarPorCiudad("Puerto Varas");
        for (Empleado e : enPuertoVaras) {
            System.out.println("- " + e.getNombre() + " " + e.getApellido() + " (" + e.getCargo() + ")");
        }

        System.out.println("\n==========================================");
        System.out.println("   FIN DE LA EJECUCIÓN");
        System.out.println("==========================================");
    }
}
