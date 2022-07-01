package ejercicioextra1.servicios;

import ejercicioextra1.entidades.*;
import ejercicioextra1.persistencia.*;
import ejercicioextra1.servicios.excepciones.LibroExcepcion;
import java.util.Scanner;

public class LibroServicio {

    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final LibroDAO LIBRO_DAO;

    public LibroServicio() {
        this.LIBRO_DAO = new LibroDAO();
    }

    public Libro crearLibro() {

        String titulo;
        Integer anio, ejemplares, idAutor, idEditorial;
        Autor autor;
        Editorial editorial;
        AutorDAO autorDao = new AutorDAO();
        EditorialDAO editorialDao = new EditorialDAO();

        System.out.println("Ingrese el título del libro:");
        titulo = SC.next();

        if (titulo == null || titulo.isEmpty()) {
            throw new LibroExcepcion("Ha ingresado un título inválido");
        }

        try {
            System.out.println("Ingrese el año del libro:");
            anio = SC.nextInt();

            System.out.println("Ingrese el número de ejemplares del libro:");
            ejemplares = SC.nextInt();
        } catch (LibroExcepcion ex) {
            throw new LibroExcepcion("Ha ingresado un valor inválido");
        }

        try {
            System.out.println("Ingrese el ID del autor del libro:");
            idAutor = SC.nextInt();

            autor = autorDao.encontrarAutorPorId(idAutor);
        } catch (NullPointerException ex) {
            AutorServicio autorServicio = new AutorServicio();
            autor = autorServicio.crearAutor();
            autorServicio.ingresarAutor(autor);
        }

        try {
            System.out.println("Ingrese el ID de la editorial del libro:");
            idEditorial = SC.nextInt();

            editorial = editorialDao.encontrarEditorialPorId(idEditorial);
        } catch (NullPointerException ex) {
            EditorialServicio editorialServicio = new EditorialServicio();
            editorial = editorialServicio.crearEditorial();
            editorialServicio.ingresarEditorial(editorial);
        }

        return new Libro(titulo, anio, ejemplares, autor, editorial);

    }

    public void ingresarLibro() {

        Libro libro = crearLibro();

        if (libro != null) {
            LIBRO_DAO.guardar(libro);
        } else if (libro == null) {
            throw new LibroExcepcion("No ha cargado correctamente el libro");
        }

    }

    public void ingresarLibro(Libro libro) {

        if (libro != null) {
            LIBRO_DAO.guardar(libro);
        } else if (libro == null) {
            throw new LibroExcepcion("No ha cargado correctamente el libro");
        }

    }

    public void devolverLibro() {

        Long isbn;

        System.out.println("Ingrese el ISBN, del libro que desea devolver:");
        isbn = SC.nextLong();

        try {
            Libro libro = LIBRO_DAO.encontrarLibroPorIsbn(isbn);
            if (libro.getEjemplaresPrestados() != 0) {
                libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() - 1);
                libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() + 1);
                LIBRO_DAO.editar(libro);
            } else {
                System.out.println("Lo siento, no se registra que el libro: " + libro.getTitulo() + ", tenga ejemplares prestados");
                System.out.println("Comuníquese con la librería, para solucionar el inconveniente");
            }
        } catch (NullPointerException ex) {
            System.out.println("Lo siento, no existe libro con ese ISBN");
        }

    }

}
