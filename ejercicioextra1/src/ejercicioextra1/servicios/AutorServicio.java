package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Autor;
import ejercicioextra1.servicios.excepciones.AutorExcepcion;
import ejercicioextra1.persistencia.AutorDAO;
import java.util.Scanner;

public class AutorServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final AutorDAO AUTOR_DAO;

    public AutorServicio() {
        this.AUTOR_DAO = new AutorDAO();
    }
    
    public Autor crearAutor() {
        
        String nombreAutor;
        
        System.out.println("Ingrese el nombre del autor:");
        nombreAutor = SC.next();
        
        if(nombreAutor == null || nombreAutor.isEmpty()){
            throw new AutorExcepcion("Ha ingresado un nombre inválido");
        }
        
        return new Autor(nombreAutor);
        
    }
    
    public void ingresarAutor() {
        
        Autor autor = crearAutor();
        
        if(autor != null){
            AUTOR_DAO.guardar(autor);
        } else if(autor == null){
            throw new AutorExcepcion("No ha cargado correctamente el autor");
        }
        
    }
    
    public void ingresarAutor(Autor autor) {
                
        if(autor != null){
            AUTOR_DAO.guardar(autor);
        } else if(autor == null){
            throw new AutorExcepcion("No ha cargado correctamente el autor");
        }
        
    }
    
}
