package ejercicio1.persistencia;

import ejercicio1.entidades.Autor;
import ejercicio1.entidades.Editorial;
import ejercicio1.entidades.Libro;
import ejercicio1.servicios.AutorServicio;
import ejercicio1.servicios.EditorialServicio;
import java.util.List;

public class LibroDAO extends DAO<Libro> {

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

    public Libro encontrarLibroPorIsbn(Long isbn) {

        conectar();
        Libro libro = em.find(Libro.class, isbn);
        desconectar();

        if(libro != null){
            return libro;
        } else {
            System.out.println("No existe libro con ese ISBN");
            return new Libro();
        }

    }

}
