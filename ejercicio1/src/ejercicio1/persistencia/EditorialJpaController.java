package ejercicio1.persistencia;

import ejercicio1.entidades.Editorial;
import ejercicio1.persistencia.excepciones.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

public class EditorialJpaController implements Serializable {

    public EditorialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;

    public EditorialJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ejercicio1PU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Editorial editorial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Editorial editorial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            editorial = em.merge(editorial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = editorial.getId();
                if (findEditorial(id) == null) {
                    throw new NonexistentEntityException("La editorial con id: " + id + ", no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Editorial editorial;
            try {
                editorial = em.getReference(Editorial.class, id);
                editorial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La editorial con id: " + id + ", no existe.", enfe);
            }
            em.remove(editorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Editorial> findEditorialEntities() {
        return findEditorialEntities(true, -1, -1);
    }

    public List<Editorial> findEditorialEntities(int maxResults, int firstResult) {
        return findEditorialEntities(false, maxResults, firstResult);
    }

    private List<Editorial> findEditorialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Editorial.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Editorial findEditorial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Editorial.class, id);
        } finally {
            em.close();
        }
    }

    public int getEditorialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Editorial> rt = cq.from(Editorial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
