package ejercicioextra1.servicios;

import ejercicioextra1.entidades.*;
import ejercicioextra1.persistencia.PrestamoDAO;
import java.sql.Date;
import java.util.Scanner;

public class PrestamoServicio {
    
    private final Scanner SC  = new Scanner(System.in).useDelimiter("\n");
    private PrestamoDAO prestamoDao;

    public PrestamoServicio() {
        this.prestamoDao = new PrestamoDAO();
    }
    
    public Prestamo crearPrestamo(){
        
        Date fechaPrestamo, fechaDevolucion;
        Libro libro;
        Cliente cliente;
        
        System.out.println("Ingrese la fecha inicial del préstamo:");
        
        System.out.println("Ingrese la fecha de devolución del préstamo:");
        
        
        return new Prestamo();
        
    }
    
}
