package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Libro;
import ejercicioextra1.persistencia.excepciones.LibroDaoExcepcion;

public class LibroDAO extends DAO<Libro>{
    
    @Override
    public void guardar(Libro libro){
        super.guardar(libro);
    }
    
    @Override
    public void editar(Libro libro){
        super.editar(libro);
    }
    
    @Override
    public void eliminar(Libro libro){
        super.eliminar(libro);
    }
    
    public Libro encontrarLibroPorIsbn(Long isbn){
        
        Libro libro = this.em.find(Libro.class, isbn);
        
        if(libro != null){
            return libro;
        } else {
            throw new LibroDaoExcepcion("Lo siento, no existe libro con ese ISBN");
        }
        
    }
    
}
