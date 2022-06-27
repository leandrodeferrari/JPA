package ejercicio1.persistencia;

import ejercicio1.entidades.Editorial;

public class EditorialDaoExt extends Dao<Editorial>{
    
    @Override
    public void guardar(Editorial editorial){
        super.guardar(editorial);
    }
    
    @Override
    public void editar(Editorial editorial){
        super.editar(editorial);
    }
    
    @Override
    public void eliminar(Editorial editorial){
        super.eliminar(editorial);
    }
    
}
