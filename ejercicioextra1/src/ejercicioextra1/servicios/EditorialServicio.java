package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Editorial;
import ejercicioextra1.persistencia.EditorialDAO;
import java.util.Scanner;

public class EditorialServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final EditorialDAO EDITORIAL_DAO;

    public EditorialServicio() {
        this.EDITORIAL_DAO = new EditorialDAO();
    }
    
    public Editorial crearEditorial(){
        
        String nombre;
        
        System.out.println("Ingrese el nombre de la editorial:");
        nombre = SC.next();
        
        return new Editorial(nombre);
        
    }
    
    public void ingresarEditorial(){
        
        Editorial editorial = crearEditorial();
        
        if(editorial != null){
            EDITORIAL_DAO.guardar(editorial);
        } else if(editorial == null){
            throw new NullPointerException("No ha cargado correctamente la editorial");
        }
        
    }
 
    public void ingresarEditorial(Editorial editorial){
        
        if(editorial != null){
            EDITORIAL_DAO.guardar(editorial);
        } else if(editorial == null){
            throw new NullPointerException("No ha cargado correctamente la editorial");
        }
        
    }
    
}
