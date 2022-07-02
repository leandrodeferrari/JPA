package ejercicio1.servicios;

import ejercicio1.entidades.*;
import ejercicio1.persistencia.*;
import ejercicio1.servicios.excepciones.LibroExcepcion;
import java.util.*;

public class LibroServicio {

    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final LibroDAO libroDao;

    public LibroServicio() {
        this.libroDao = new LibroDAO();
    }

    public Libro crearLibro() throws Exception {

        AutorServicio autorServicio = new AutorServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        String tituloLibro;
        Integer anioLibro, ejemplaresLibro, idAutor, idEditorial;
        Long isbn;
        Editorial editorial;
        Autor autor;
        EditorialDAO editorialDao = new EditorialDAO();
        AutorDAO autorDao = new AutorDAO();

        System.out.println("Ingrese el título del libro:");
        tituloLibro = SC.next();

        if (tituloLibro == null || tituloLibro.trim().isEmpty()) {
            throw new LibroExcepcion("Ha ingresado un nombre inválido");
        }

        try {
            System.out.println("ingrese su ISBN");
            isbn = SC.nextLong();

            System.out.println("Ingrese el año del libro:");
            anioLibro = SC.nextInt();

            System.out.println("Ingrese los ejemplares del libro:");
            ejemplaresLibro = SC.nextInt();
        } catch (LibroExcepcion ex) {
            throw new LibroExcepcion("Ha ingresado un número inválido");
        }

        try {
            System.out.println("Ingrese el ID de su autor:");
            idAutor = SC.nextInt();

            autor = autorDao.encontrarAutorPorId(idAutor);
        } catch (NullPointerException ex) {
            autor = autorServicio.crearAutor();

            if (autor != null) {
                autorDao.guardar(autor);
            }

        }

        try {
            System.out.println("Ingrese el ID de su editorial:");
            idEditorial = SC.nextInt();

            editorial = editorialDao.encontrarEditorialPorId(idEditorial);
        } catch (NullPointerException ex) {
            editorial = editorialServicio.crearEditorial();

            if (editorial != null) {
                editorialDao.guardar(editorial);
            }

        }

        Libro libro = new Libro(isbn, tituloLibro, anioLibro, ejemplaresLibro, autor, editorial);

        return libro;

    }

    public void guardarLibro() throws Exception {
        Libro libro = crearLibro();

        if (libro == null) {
            throw new LibroExcepcion("Ha ingresado un libro inválido");
        }

        libroDao.guardar(libro);
    }

    public void darDeAltaLibro() throws Exception {

        // No me dejaba ponerle 0.
        Long isbn = Long.MIN_VALUE;

        try {
            System.out.println("Ingrese el ISBN del libro que desea dar de alta:");
            isbn = SC.nextLong();
        } catch (LibroExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Libro libroEncontrado = libroDao.encontrarLibroPorIsbn(isbn);

        if (libroEncontrado == null || isbn == Long.MIN_VALUE) {
            System.out.println("No existe libro con ese ISBN");
        } else if (libroEncontrado.isAlta()) {
            System.out.println("Tu libro ya está dado de alta");
        } else {
            libroEncontrado.setAlta(Boolean.TRUE);
            libroDao.editar(libroEncontrado);
        }

    }

    public void darDeBajaLibro() throws Exception {

        Long isbn = Long.MIN_VALUE;

        try {
            System.out.println("Ingrese el ISBN del libro que desea dar de alta:");
            isbn = SC.nextLong();
        } catch (LibroExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Libro libroEncontrado = libroDao.encontrarLibroPorIsbn(isbn);

        if (libroEncontrado == null) {
            System.out.println("No existe libro con ese ISBN");
        } else if (libroEncontrado.isAlta()) {
            libroEncontrado.setAlta(Boolean.FALSE);
            libroDao.editar(libroEncontrado);
        } else {
            System.out.println("Tu libro ya está dado de baja");
        }

    }

    public void buscarLibroPorISBN() {

        Long isbn = Long.MIN_VALUE;

        try {
            System.out.println("Ingrese el ISBN que desea buscar:");
            isbn = SC.nextLong();
        } catch (LibroExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Libro libroEncontrado = libroDao.encontrarLibroPorIsbn(isbn);

        if (libroEncontrado == null || isbn == Long.MIN_VALUE) {
            System.out.println("No existe libro con ese ISBN");
        } else {
            System.out.println(libroEncontrado.toString());
        }

    }

    public void buscarLibroPorTitulo() {

        String titulo;

        System.out.println("Ingrese el título que desea buscar:");
        titulo = SC.next();

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new LibroExcepcion("Ha ingresado un título inválido");
        }

        List<Libro> libros = libroDao.encontrarLibroPorTitulo(titulo);

        if (!libros.isEmpty()) {
            libros.forEach((libro) -> {
                System.out.println(libro.toString());
            });
        } else {
            System.out.println("No se encontraron libros con ese título");
        }

    }

    public void buscarLibroPorNombreDeAutor() {

        String nombreAutor;

        System.out.println("Ingrese el nombre del autor del libro:");
        nombreAutor = SC.next();

        if (nombreAutor == null || nombreAutor.trim().isEmpty()) {
            throw new LibroExcepcion("Ha ingresado un nombre inválido");
        }

        List<Libro> libros = libroDao.encontrarLibrosPorNombreAutor(nombreAutor);

        if (libros == null || libros.isEmpty()) {
            System.out.println("No hay libros de dicho autor");
        } else {
            libros.forEach((libro) -> {
                System.out.println(libro.toString());
            });
        }

    }

    public void buscarLibroPorNombreDeEditorial() {

        String nombreEditorial;

        System.out.println("Ingrese el nombre de la editorial:");
        nombreEditorial = SC.next();

        if (nombreEditorial == null || nombreEditorial.trim().isEmpty()) {
            throw new LibroExcepcion("Ha ingresado un nombre inválido");
        }

        List<Libro> libros = libroDao.encontrarLibrosPorNombreEditorial(nombreEditorial);

        if (libros == null || libros.isEmpty()) {
            System.out.println("No hay libros de dicha editorial");
        } else {
            libros.forEach((libro) -> {
                System.out.println(libro.toString());
            });
        }

    }

}
