package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Cliente;
import ejercicioextra1.persistencia.excepciones.ClienteDaoExcepcion;

public class ClienteDAO extends DAO<Cliente>{
    
    @Override
    public void guardar(Cliente cliente){
        super.guardar(cliente);
    }
    
    @Override
    public void editar(Cliente cliente){
        super.editar(cliente);
    }
    
    @Override
    public void eliminar(Cliente cliente){
        super.eliminar(cliente);
    }
    
    public Cliente encontrarClientePorId(Integer id) {
        
        Cliente cliente = this.em.find(Cliente.class, id);
        
        if(cliente != null){
            return cliente;
        } else {
            throw new ClienteDaoExcepcion("Lo siento, no existe cliente con ese ID");
        }
        
    }
    
}
