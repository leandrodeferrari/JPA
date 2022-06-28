package ejercicio1.persistencia;

import ejercicio1.entidades.Autor;
import ejercicio1.entidades.Editorial;
import ejercicio1.entidades.Libro;
import ejercicio1.servicios.AutorServicio;
import ejercicio1.servicios.EditorialServicio;
import java.util.List;

public class LibroDaoExt extends Dao<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    @Override
    public void editar(Libro libro) {
        super.editar(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }

    public List<Libro> encontrarLibroPorTitulo(String titulo) {

        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getResultList();
        desconectar();

        return libros;

    }

    public List<Libro> encontrarLibrosPorNombreAutor(String nombreAutor) {

        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre = :nombreAutor").setParameter("nombreAutor", nombreAutor).getResultList();
        desconectar();

        return libros;

    }

    public List<Libro> encontrarLibrosPorNombreEditorial(String nombreEditorial) {

        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre = :nombreEditorial").setParameter("nombreEditorial", nombreEditorial).getResultList();
        desconectar();

        return libros;

    }

    public Autor encontrarAutorParaLibro(int id) {

        AutorDaoExt autorDao = new AutorDaoExt();
        AutorServicio autorServicio = new AutorServicio();

        Autor autor = autorDao.encontrarAutorPorId(id);

        if (autor == null) {
            autor = autorServicio.crearAutor();
            autorDao.guardar(autor);
        }

        return autor;

    }

    public Editorial encontrarEditorialParaLibro(int id) {

        EditorialDaoExt editorialDao = new EditorialDaoExt();
        EditorialServicio editorialServicio = new EditorialServicio();

        Editorial editorial = editorialDao.encontrarEditorialPorId(id);

        if (editorial == null) {
            editorial = editorialServicio.crearEditorial();
            editorialDao.guardar(editorial);
        }

        return editorial;

    }
    
}
