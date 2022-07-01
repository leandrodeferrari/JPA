package ejercicioextra1.persistencia;

import javax.persistence.*;

public class DAO<T>{
    
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("ejercicioextra1PU");
    protected EntityManager em = EMF.createEntityManager();
    
    protected void conectar(){
        
        if(!em.isOpen()){
            this.em = EMF.createEntityManager();
        }
        
    }
    
    protected void desconectar(){
        
        if(em.isOpen()){
            this.em.close();
        }
        
    }
    
    protected void guardar(T objeto){
        
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto){
        
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        
    }
    
    protected void eliminar(T objeto){
        
        conectar();
        em.getTransaction().begin();
        T objeto1 = em.merge(objeto);
        em.remove(objeto1);
        em.getTransaction().commit();
        desconectar();
        
    }
    
}
