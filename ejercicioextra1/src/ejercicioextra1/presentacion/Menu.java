package ejercicioextra1.presentacion;

import ejercicioextra1.servicios.*;
import java.util.Scanner;

public class Menu {

    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private Integer opcionPrincipal;
    private Integer opcionCreacion;

    public Menu() {
        this.opcionPrincipal = 0;
        this.opcionCreacion = 0;
    }

    private void vistaMenuCreacion() {

        System.out.println("1. Crear autor");
        System.out.println("2. Crear cliente");
        System.out.println("3. Crear editorial");
        System.out.println("4. Crear libro");
        System.out.println("5. Crear préstamo");
        System.out.println("6. Salir");

    }

    private void ejecutarOpcionCreacion(Integer opcionCreacion) {

        switch (opcionCreacion) {

            case 1:
                ejecutarOpcion1Creacion();
                break;

            case 2:
                ejecutarOpcion2Creacion();
                break;

            case 3:
                ejecutarOpcion3Creacion();
                break;

            case 4:
                ejecutarOpcion4Creacion();
                break;

            case 5:
                ejecutarOpcion5Creacion();
                break;

            case 6:
                ejecutarOpcion6Creacion();
                break;

            default:
                ejecutarOpcionDefaultCreacion();
                this.opcionCreacion = 0;
                break;
        }

    }

    private void ejecutarOpcion1Creacion() {
        AutorServicio autorServicio = new AutorServicio();
        autorServicio.ingresarAutor();
    }

    private void ejecutarOpcion2Creacion() {
        ClienteServicio clienteServicio = new ClienteServicio();
        clienteServicio.ingresarCliente();
    }

    private void ejecutarOpcion3Creacion() {
        EditorialServicio editorialServicio = new EditorialServicio();
        editorialServicio.ingresarEditorial();
    }

    private void ejecutarOpcion4Creacion() {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.ingresarLibro();
    }

    private void ejecutarOpcion5Creacion() {
        PrestamoServicio prestamoServicio = new PrestamoServicio();
        prestamoServicio.ingresarPrestamo();
    }

    private void ejecutarOpcion6Creacion() {
        System.out.println("Cargando menú principal...");
    }

    private void ejecutarOpcionDefaultCreacion() {
        System.out.println("Lo siento, ha ingresado una opción inválida");
    }

    public void ejecutarMenu() {

        while (opcionCreacion != 6) {

            vistaMenuCreacion();
            this.opcionCreacion = SC.nextInt();

            ejecutarOpcionCreacion(opcionCreacion);

        }

        while (opcionPrincipal != 4) {

            vistaMenuPrincipal();
            this.opcionPrincipal = SC.nextInt();

            ejecutarMenuPrincipal(opcionPrincipal);

        }

    }

    private void vistaMenuPrincipal() {

        System.out.println("1. Registrar el préstamo de un libro");
        System.out.println("2. Devolución de un libro");
        System.out.println("3. Búsqueda de todos los prestamos de un Cliente");
        System.out.println("4. Salir");

    }

    private void ejecutarMenuPrincipal(Integer opcionPrincipal) {

        switch (opcionPrincipal) {

            case 1:
                ejecutarOpcion1Principal();
                break;

            case 2:
                ejecutarOpcion2Principal();
                break;

            case 3:
                ejecutarOpcion3Principal();
                break;

            case 4:
                ejecutarOpcion4Principal();
                break;

            default:
                ejecutarOpcionDefaultPrincipal();
                break;

        }

    }

    private void ejecutarOpcion1Principal() {

    }

    private void ejecutarOpcion2Principal() {

    }

    private void ejecutarOpcion3Principal() {
        PrestamoServicio prestamoServicio = new PrestamoServicio();
        prestamoServicio.mostrarPrestamosDeUnCliente();
    }

    private void ejecutarOpcion4Principal() {
        System.out.println("¡Hasta la próxima!");
    }

    private void ejecutarOpcionDefaultPrincipal() {
        System.out.println("Lo siento, ha ingresado una opción incorrecta");
        System.out.println("Vuelva a intentarlo");
        this.opcionPrincipal = 0;
    }

}
