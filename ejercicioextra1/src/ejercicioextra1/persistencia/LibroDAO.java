package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Libro;

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
    
    public Libro encontrarLibroPorId(Long isbn){
        
        Libro libro = this.em.find(Libro.class, isbn);
        
        if(libro != null){
            return libro;
        } else {
            throw new NullPointerException("Lo siento, no existe libro con ese ISBN.");
        }
        
    }
    
}
