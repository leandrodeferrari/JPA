package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Editorial;
import ejercicioextra1.persistencia.EditorialDAO;
import ejercicioextra1.servicios.excepciones.EditorialExcepcion;
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
        
        if(nombre == null || nombre.isEmpty()){
            throw new EditorialExcepcion("Ha ingresado un nombre inválido");
        }
        
        return new Editorial(nombre);
        
    }
    
    public void ingresarEditorial(){
        
        Editorial editorial = crearEditorial();
        
        if(editorial != null){
            EDITORIAL_DAO.guardar(editorial);
        } else if(editorial == null){
            throw new EditorialExcepcion("No ha cargado correctamente la editorial");
        }
        
    }
 
    public void ingresarEditorial(Editorial editorial){
        
        if(editorial != null){
            EDITORIAL_DAO.guardar(editorial);
        } else if(editorial == null){
            throw new EditorialExcepcion("No ha cargado correctamente la editorial");
        }
        
    }
    
}
