package ejercicioextra1.servicios;

import ejercicioextra1.entidades.*;
import ejercicioextra1.persistencia.*;
import java.util.Scanner;

public class LibroServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final LibroDAO LIBRO_DAO;

    public LibroServicio() {
        this.LIBRO_DAO = new LibroDAO();
    }
    
    public Libro crearLibro(){
        
        String titulo;
        Integer anio, ejemplares, idAutor, idEditorial;
        Autor autor;
        Editorial editorial;
        AutorDAO autorDao = new AutorDAO();
        EditorialDAO editorialDao = new EditorialDAO();
        
        System.out.println("Ingrese el título del libro:");
        titulo = SC.next();
        
        System.out.println("Ingrese el año del libro:");
        anio =SC.nextInt();
        
        System.out.println("Ingrese el número de ejemplares del libro:");
        ejemplares = SC.nextInt();

        System.out.println("Ingrese el ID del autor del libro:");
        idAutor = SC.nextInt();
        
        try {
            autor = autorDao.encontrarAutorPorId(idAutor);
        } catch (NullPointerException ex) {
            AutorServicio autorServicio = new AutorServicio();
            autor = autorServicio.crearAutor();
            autorServicio.ingresarAutor(autor);
        }
        
        System.out.println("Ingrese el ID de la editorial del libro:");
        idEditorial = SC.nextInt();
        
        try {
            editorial = editorialDao.encontrarEditorialPorId(idEditorial);
        } catch (NullPointerException ex) {
            EditorialServicio editorialServicio = new EditorialServicio();
            editorial = editorialServicio.crearEditorial();
            editorialServicio.ingresarEditorial(editorial);
        }
        
        return new Libro(titulo, anio, ejemplares, autor, editorial);
            
    }
    
    public void ingresarLibro(){
        
        Libro libro = crearLibro();
        
        if(libro != null){
            LIBRO_DAO.guardar(libro);
        } else if(libro == null){
            throw new NullPointerException("No ha cargado correctamente el libro");
        }
        
    }
    
    public void ingresarLibro(Libro libro){
        
        if(libro != null){
            LIBRO_DAO.guardar(libro);
        } else if(libro == null){
            throw new NullPointerException("No ha cargado correctamente el libro");
        }
        
    }
    
}
