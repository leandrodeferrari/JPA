package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Editorial;
import ejercicioextra1.persistencia.excepciones.EditorialDaoExcepcion;

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
    
    public Editorial encontrarEditorialPorId(Integer id) {
        
        Editorial editorial = this.em.find(Editorial.class, id);
        
        if(editorial != null){
            return editorial;
        } else {
            throw new EditorialDaoExcepcion("Lo siento, no existe editorial con ese ID");
        }
        
    }
    
}
