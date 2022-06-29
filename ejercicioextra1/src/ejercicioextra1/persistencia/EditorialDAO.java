package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial>{
    
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
