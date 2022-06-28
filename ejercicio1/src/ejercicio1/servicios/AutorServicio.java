package ejercicio1.servicios;

import ejercicio1.entidades.Autor;
import ejercicio1.persistencia.AutorDaoExt;
import ejercicio1.persistencia.AutorJpaController;
import java.util.List;
import java.util.Scanner;

public class AutorServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final AutorDaoExt autorDao;
    private final AutorJpaController autorJpa;

    public AutorServicio() {
        this.autorDao = new AutorDaoExt();
        this.autorJpa = new AutorJpaController();
    }

    public Autor crearAutor() {

        String nombreAutor;
        Boolean alta = true;

        System.out.println("Ingrese el nombre del autor:");
        nombreAutor = leer.next();

        Autor autor = new Autor(nombreAutor, alta);

        return autor;

    }

    public void guardarAutor() throws Exception{
        Autor autor = crearAutor();
        autorJpa.create(autor);
    }
    
    public void darDeAltaAutor() throws Exception {

        Integer id;

        System.out.println("Ingrese el id del autor que quiere dar de alta:");
        id = leer.nextInt();

        Autor autorEncontrado = autorJpa.findAutor(id);

        if (autorEncontrado == null) {
            throw new NullPointerException("No existe editorial con este id");
        } else if (autorEncontrado.isAlta()) {
            throw new RuntimeException("Tu autor ya está dado de alta");
        } else {
            autorEncontrado.setAlta(Boolean.TRUE);
            autorJpa.edit(autorEncontrado);
        }

    }

    public void darDeBajaAutor() throws Exception {

        Integer id;

        System.out.println("Ingrese el id del autor que quiere dar de alta:");
        id = leer.nextInt();

        Autor autorEncontrado = autorJpa.findAutor(id);

        if (autorEncontrado == null) {
            throw new NullPointerException("No existe autor con ese id");
        } else if (autorEncontrado.isAlta()) {
            autorEncontrado.setAlta(Boolean.FALSE);
            autorJpa.edit(autorEncontrado);
        } else {
            throw new RuntimeException("Tu autor ya está dado de baja");
        }

    }

    public void buscarAutorPorNombre() {

        String nombre;

        System.out.println("Ingrese el nombre del autor que desea buscar");
        nombre = leer.next();

        List<Autor> autores = autorDao.encontrarAutorPorNombre(nombre);

        if (autores == null) {
            throw new NullPointerException("Lo siento, no existe un autor con ese nombre");
        } else {
            autores.forEach((autor) -> {
                System.out.println(autor.toString());
            });
        }

    }
    
    public Autor traerAutorPorId(int id){
        Autor autor = autorDao.encontrarAutorPorId(id);
        return autor;
    }
    
}
