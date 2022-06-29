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
    
}
