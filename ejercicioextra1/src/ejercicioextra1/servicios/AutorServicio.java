package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Autor;
import ejercicioextra1.persistencia.AutorDAO;
import java.util.Scanner;

public class AutorServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private AutorDAO autorDao;

    public AutorServicio() {
        this.autorDao = new AutorDAO();
    }
    
    public Autor crearAutor(){
        
        String nombreAutor;
        
        System.out.println("Ingrese el nombre del autor:");
        nombreAutor = SC.next();
        
        return new Autor(nombreAutor);
        
    }
    
}
