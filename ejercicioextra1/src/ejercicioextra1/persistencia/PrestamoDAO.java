package ejercicioextra1.persistencia;

import ejercicioextra1.entidades.Prestamo;
import ejercicioextra1.persistencia.excepciones.PrestamoDaoExcepcion;
import java.util.*;

public class PrestamoDAO extends DAO<Prestamo>{
    
    @Override
    public void guardar(Prestamo prestamo){
        super.guardar(prestamo);
    }
    
    @Override
    public void editar(Prestamo prestamo){
        super.editar(prestamo);
    }
    
    @Override
    public void eliminar(Prestamo prestamo){
        super.eliminar(prestamo);
    }
 
    public Prestamo encontrarPrestamoPorId(Integer id){
        
        Prestamo prestamo = this.em.find(Prestamo.class, id);
        
        if(prestamo != null){
            return prestamo;
        } else {
            throw new PrestamoDaoExcepcion("Lo siento, no existe préstamo con ese ID");
        }
        
    }
    
    public List<Prestamo> consultarPrestamosDeUnCliente(Integer idCliente){
        
        List<Prestamo> prestamos = em.createQuery
        ("SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.id = :idCliente")
                .setParameter("idCliente", idCliente).getResultList();
        
        if(prestamos != null){
            return prestamos;
        } else {
            prestamos = new ArrayList<>();
            return prestamos;
        }
        
    }
    
}
