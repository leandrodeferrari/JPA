package ejercicioextra1.servicios;

import ejercicioextra1.entidades.*;
import ejercicioextra1.persistencia.LibroDAO;
import java.util.Scanner;

public class LibroServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private LibroDAO libroDao;

    public LibroServicio() {
        this.libroDao = new LibroDAO();
    }
    
    public Libro crearLibro(){
        
        String titulo;
        Integer anio, ejemplares;
        Autor autor;
        Editorial editorial;
        
        System.out.println("Ingrese el título del libro:");
        titulo = SC.next();
        
        System.out.println("Ingrese el año del libro:");
        anio =SC.nextInt();
        
        System.out.println("Ingrese el número de ejemplares del libro:");
        ejemplares = SC.nextInt();

        return new Libro();
            
    }
    
    
}
