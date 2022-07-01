package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Autor;

public class AutorDAO extends DAO<Autor>{
    
    @Override
    public void guardar(Autor autor){
        super.guardar(autor);
    }
    
    @Override
    public void editar(Autor autor){
        super.editar(autor);
    }
    
    @Override
    public void eliminar(Autor autor){
        super.eliminar(autor);
    }
    
    public Autor encontrarAutorPorId(Integer id){
        
        Autor autor = this.em.find(Autor.class, id);
        
        if(autor != null){
            return autor;
        } else {
            throw new NullPointerException("Lo siento, no existe autor con ese ID.");
        }
        
    }
    
}
