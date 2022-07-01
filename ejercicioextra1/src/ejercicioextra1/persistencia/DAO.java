package ejercicioextra1.persistencia;

import ejercicioextra1.persistencia.excepciones.DaoExcepcion;
import javax.persistence.*;

public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("ejercicioextra1PU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {

        try {
            if (!em.isOpen()) {
                this.em = EMF.createEntityManager();
            }
        } catch (DaoExcepcion ex) {
            throw new DaoExcepcion("Error al conectar, en la base de datos");
        }

    }

    protected void desconectar() {

        try {
            if (em.isOpen()) {
                this.em.close();
            }
        } catch (DaoExcepcion ex) {
            throw new DaoExcepcion("Error al desconectar, en la base de datos");
        }

    }

    protected void guardar(T objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (DaoExcepcion ex) {
            throw new DaoExcepcion("Error al guardar, en la base de datos");
        }

    }

    protected void editar(T objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
            desconectar();
        } catch (DaoExcepcion ex) {
            throw new DaoExcepcion("Error al editar, en la base de datos");
        }

    }

    protected void eliminar(T objeto) {

        try {
            conectar();
            em.getTransaction().begin();
            T objeto1 = em.merge(objeto);
            em.remove(objeto1);
            em.getTransaction().commit();
            desconectar();
        } catch (DaoExcepcion ex) {
            throw new DaoExcepcion("Error al eliminar, en la base de datos");
        }

    }

}
