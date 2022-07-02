package ejercicio1.persistencia;

import ejercicio1.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    @Override
    public void editar(Editorial editorial) {
        super.editar(editorial);
    }

    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial);
    }

    public Editorial encontrarEditorialPorId(int id) {
        conectar();
        
        Editorial editorial = (Editorial) em.createQuery
        ("SELECT e FROM Editorial e WHERE e.id = :id").setParameter("id", id).getSingleResult();
        desconectar();

        return editorial;
    }

}
