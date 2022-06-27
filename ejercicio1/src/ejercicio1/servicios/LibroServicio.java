package ejercicio1.servicios;

import ejercicio1.entidades.*;
import ejercicio1.persistencia.LibroDaoExt;
import ejercicio1.persistencia.LibroJpaController;
import java.util.List;
import java.util.Scanner;

public class LibroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final LibroDaoExt libroDao;
    private final LibroJpaController libroJpa;

    public LibroServicio() {
        this.libroDao = new LibroDaoExt();
        this.libroJpa = new LibroJpaController();
    }

    public Libro crearLibro() {

        AutorServicio autorServicio = new AutorServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        String tituloLibro;
        Integer anioLibro, ejemplaresLibro;
        Boolean alta = true;

        System.out.println("Ingrese el título del libro:");
        tituloLibro = leer.next();

        System.out.println("Ingrese el año del libro:");
        anioLibro = leer.nextInt();

        System.out.println("Ingrese los ejemplares del libro:");
        ejemplaresLibro = leer.nextInt();

        Autor autor = autorServicio.crearAutor();

        Editorial editorial = editorialServicio.crearEditorial();

        Libro libro = new Libro(tituloLibro, anioLibro, ejemplaresLibro, alta, autor, editorial);

        return libro;

    }

    public void guardarLibro() throws Exception {
        Libro libro = crearLibro();
        libroJpa.create(libro);
    }
    
    public void darDeAltaLibro() throws Exception {

        Long isbn;

        System.out.println("Ingrese el ISBN del libro que desea dar de alta:");
        isbn = leer.nextLong();

        Libro libroEncontrado = libroJpa.findLibro(isbn);

        if (libroEncontrado == null) {
            throw new NullPointerException("No existe libro con ese ISBN");
        } else if (libroEncontrado.isAlta()) {
            throw new RuntimeException("Tu libro ya está dado de alta");
        } else {
            libroEncontrado.setAlta(Boolean.TRUE);
            libroJpa.edit(libroEncontrado);
        }

    }

    public void darDeBajaLibro() throws Exception {

        Long isbn;

        System.out.println("Ingrese el ISBN del libro que desea dar de alta:");
        isbn = leer.nextLong();

        Libro libroEncontrado = libroJpa.findLibro(isbn);

        if (libroEncontrado == null) {
            throw new NullPointerException("No existe libro con ese ISBN");
        } else if (libroEncontrado.isAlta()) {
            libroEncontrado.setAlta(Boolean.FALSE);
            libroJpa.edit(libroEncontrado);
        } else {
            throw new RuntimeException("Tu libro ya está dado de baja");
        }

    }

    public void buscarLibroPorISBN() {

        Long isbn;

        System.out.println("Ingrese el ISBN que desea buscar:");
        isbn = leer.nextLong();

        Libro libroEncontrado = libroJpa.findLibro(isbn);

        if (libroEncontrado == null) {
            throw new NullPointerException("No existe libro con ese ISBN");
        } else {
            System.out.println(libroEncontrado.toString());
        }

    }

    public void buscarLibroPorTitulo() {

        String titulo;

        System.out.println("Ingrese el título que desea buscar:");
        titulo = leer.next();

        List<Libro> libros = libroDao.encontrarLibroPorTitulo(titulo);

        libros.forEach((libro) -> {
            System.out.println(libro.toString());
        });

    }

    public void buscarLibroPorNombreDeAutor() {

        String nombreAutor;

        System.out.println("Ingrese el nombre del autor del libro:");
        nombreAutor = leer.next();

        List<Libro> libros = libroDao.encontrarLibrosPorNombreAutor(nombreAutor);

        libros.forEach((libro) -> {
            System.out.println(libro.toString());
        });

    }

    public void buscarLibroPorNombreDeEditorial() {

        String nombreEditorial;

        System.out.println("Ingrese el nombre de la editorial:");
        nombreEditorial = leer.next();

        List<Libro> libros = libroDao.encontrarLibrosPorNombreEditorial(nombreEditorial);

        libros.forEach((libro) -> {
            System.out.println(libro.toString());
        });

    }

}
