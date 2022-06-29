package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Cliente;

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
    
}
