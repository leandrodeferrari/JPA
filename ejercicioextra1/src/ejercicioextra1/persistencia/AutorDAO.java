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
    
}
