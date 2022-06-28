package ejercicio1.persistencia;

import ejercicio1.entidades.Autor;
import java.util.List;

public class AutorDaoExt extends Dao<Autor>{
    
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
    
    public List<Autor> encontrarAutorPorNombre(String nombre){
        
        conectar();
        List<Autor> autores = em.createQuery
        ("SELECT a FROM Autor a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        
        return autores;
        
    }
    
    public Autor encontrarAutorPorId(int id){
        conectar();
        Autor autor = (Autor) em.createQuery
        ("SELECT a FROM Autor a WHERE a.id = :id").setParameter("id", id).getSingleResult();
        desconectar();
        System.out.println(autor);
        return autor;
        
    }
    
}
