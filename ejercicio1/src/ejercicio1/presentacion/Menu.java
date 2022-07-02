package ejercicio1.presentacion;

import ejercicio1.presentacion.excepciones.MenuExcepcion;
import ejercicio1.servicios.*;
import java.util.Scanner;

public class Menu {

    Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private Integer opcion;
    private Integer opcionCreacion;

    public Menu() {
        this.opcion = 0;
        this.opcionCreacion = 0;
    }

    private void vistaMenuCreacion() {

        System.out.println("¡Bienvenido al menú de creación de la librería!");
        System.out.println("¿Qué desea guardar?");
        System.out.println("1) Autor");
        System.out.println("2) Editorial");
        System.out.println("3) Libro");
        System.out.println("4) Salir");

    }

    private void ejecutarMenuCreacion() throws Exception {

        while (this.opcionCreacion != 4) {

            vistaMenuCreacion();

            try {
                this.opcionCreacion = SC.nextInt();
            } catch (MenuExcepcion ex) {
                ex.printStackTrace(System.out);
            }

            this.opcionCreacion = ejecutarOpcionDeCreacion(this.opcionCreacion);

        }

    }

    private int ejecutarOpcionDeCreacion(int opcionCreacion) throws Exception {

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
            default:
                ejecutarOpcionDefaultCreacion();

        }

        return opcionCreacion;

    }

    private void ejecutarOpcion1Creacion() throws Exception {
        AutorServicio autorServicio = new AutorServicio();
        autorServicio.guardarAutor();
    }

    private void ejecutarOpcion2Creacion() throws Exception {
        EditorialServicio editorialServicio = new EditorialServicio();
        editorialServicio.guardarEditorial();
    }

    private void ejecutarOpcion3Creacion() throws Exception {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.guardarLibro();

    }

    private void ejecutarOpcion4Creacion() {
        System.out.println("Serás autodirigido al menú de la librería...");
    }

    public void ejecutarOpcionDefaultCreacion() {
        System.out.println("Lo siento, ha ingresado una opción inválida");
        this.opcionCreacion = 0;
    }

    private void vistaMenu() {

        System.out.println("¡Bienvenido al menú de la librería!");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1) Buscar autor por nombre");
        System.out.println("2) Buscar libro por ISBN");
        System.out.println("3) Buscar libro por título");
        System.out.println("4) Buscar libros por nombre de autor");
        System.out.println("5) Buscar libros por nombre de editorial");
        System.out.println("6) Dar de alta");
        System.out.println("7) Dar de baja");
        System.out.println("8) Salir");

    }

    private void vistaMenuAlta() {

        System.out.println("¿A cuál quiere dar de alta?");
        System.out.println("1) Autor");
        System.out.println("2) Editorial");
        System.out.println("3) Libro");
        System.out.println("4) Volver");

    }

    private void vistaMenuBaja() {

        System.out.println("¿A cuál quiere dar de baja?");
        System.out.println("1) Autor");
        System.out.println("2) Editorial");
        System.out.println("3) Libro");
        System.out.println("4) Volver");

    }

    public void ejecutarMenu() throws Exception {

        ejecutarMenuCreacion();

        while (this.opcion != 8) {

            vistaMenu();

            try {
                this.opcion = SC.nextInt();
            } catch (MenuExcepcion ex) {
                ex.printStackTrace(System.out);
            }

            this.opcion = ejecutarOpcion(opcion);

        }

    }

    public int ejecutarOpcion(Integer opcion) throws Exception {

        switch (opcion) {
            case 1:
                ejecutarOpcion1();
                break;
            case 2:
                ejecutarOpcion2();
                break;
            case 3:
                ejecutarOpcion3();
                break;
            case 4:
                ejecutarOpcion4();
                break;
            case 5:
                ejecutarOpcion5();
                break;
            case 6:
                ejecutarOpcion6();
                break;
            case 7:
                ejecutarOpcion7();
                break;
            case 8:
                ejecutarOpcion8();
                break;
            default:
                ejecutarOpcionDefault();
                
        }

        return opcion;

    }

    private void ejecutarOpcion1() {
        AutorServicio autorServicio = new AutorServicio();
        autorServicio.buscarAutorPorNombre();
    }

    private void ejecutarOpcion2() {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.buscarLibroPorISBN();
    }

    private void ejecutarOpcion3() {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.buscarLibroPorTitulo();
    }

    private void ejecutarOpcion4() {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.buscarLibroPorNombreDeAutor();
    }

    private void ejecutarOpcion5() {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.buscarLibroPorNombreDeEditorial();
    }

    private void ejecutarOpcion6() throws Exception {
        vistaMenuAlta();

        try {
            this.opcion = SC.nextInt();
        } catch (MenuExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        this.opcion = ejecutarOpcionAlta(this.opcion);
    }

    private void ejecutarOpcion7() throws Exception {
        vistaMenuBaja();

        try {
            this.opcion = SC.nextInt();
        } catch (MenuExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        this.opcion = ejecutarOpcionBaja(this.opcion);
    }

    private void ejecutarOpcion8() {
        System.out.println("¡Hasta la próxima!");
    }

    private void ejecutarOpcionDefault() {
        System.out.println("Lo siento, ha ingresado una opción inválida");
        this.opcion = 0;
    }

    private int ejecutarOpcionAlta(int opcion) throws Exception {

        switch (opcion) {
            case 1:
                ejecutarOpcion1Alta();
                break;
            case 2:
                ejecutarOpcion2Alta();
                break;
            case 3:
                ejecutarOpcion3Alta();
                break;
            case 4:
                ejecutarOpcionVolver();
                break;
            default:
                ejecutarOpcionDefault();
                
        }

        return opcion;

    }

    private void ejecutarOpcion1Alta() throws Exception {
        AutorServicio autorServicio = new AutorServicio();
        autorServicio.darDeAltaAutor();
    }

    private void ejecutarOpcion2Alta() throws Exception {
        EditorialServicio editorialServicio = new EditorialServicio();
        editorialServicio.darDeAltaLaEditorial();
    }

    private void ejecutarOpcion3Alta() throws Exception {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.darDeAltaLibro();
    }

    private void ejecutarOpcionVolver() {
        System.out.println("Cargando...");
    }

    private Integer ejecutarOpcionBaja(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                ejecutarOpcion1Baja();
                break;
            case 2:
                ejecutarOpcion2Baja();
                break;
            case 3:
                ejecutarOpcion3Baja();
                break;
            case 4:
                ejecutarOpcionVolver();
                break;
            default:
                ejecutarOpcionDefault();
                
        }

        return opcion;

    }

    private void ejecutarOpcion1Baja() throws Exception {
        AutorServicio autorServicio = new AutorServicio();
        autorServicio.darDeBajaAutor();
    }

    private void ejecutarOpcion2Baja() throws Exception {
        EditorialServicio editorialServicio = new EditorialServicio();
        editorialServicio.darDeBajaLaEditorial();
    }

    private void ejecutarOpcion3Baja() throws Exception {
        LibroServicio libroServicio = new LibroServicio();
        libroServicio.darDeBajaLibro();
    }

}
