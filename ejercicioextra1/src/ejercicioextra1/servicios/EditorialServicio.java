package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Editorial;
import ejercicioextra1.persistencia.EditorialDAO;
import java.util.Scanner;

public class EditorialServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private EditorialDAO editorialDao;

    public EditorialServicio() {
        this.editorialDao = new EditorialDAO();
    }
    
    public Editorial crearEditorial(){
        
        String nombre;
        
        System.out.println("Ingrese el nombre de al editorial:");
        nombre = SC.next();
        
        return new Editorial(nombre);
        
    }
    
}
