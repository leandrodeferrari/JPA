package ejercicio1.servicios;

import ejercicio1.entidades.Autor;
import ejercicio1.persistencia.AutorDAO;
import ejercicio1.servicios.excepciones.AutorExcepcion;
import java.util.*;

public class AutorServicio {

    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final AutorDAO autorDao;

    public AutorServicio() {
        this.autorDao = new AutorDAO();
    }

    public Autor crearAutor() {

        String nombreAutor;
        Boolean alta = true;

        System.out.println("Ingrese el nombre del autor:");
        nombreAutor = SC.next();

        if (nombreAutor == null || nombreAutor.trim().isEmpty()) {
            throw new AutorExcepcion("No ha ingresado un nombre de autor válido");
        }

        Autor autor = new Autor(nombreAutor, alta);

        return autor;

    }

    public Autor guardarAutor() {
        Autor autor = crearAutor();

        if (autor != null) {
            autorDao.guardar(autor);
        } else {
            throw new AutorExcepcion("No ha ingresado un autor válido");
        }

        return autor;
    }

    public void darDeAltaAutor() throws Exception {

        Integer id = 0;

        try {
            System.out.println("Ingrese el id del autor, que quiere dar de alta:");
            id = SC.nextInt();
        } catch (AutorExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Autor autorEncontrado = autorDao.encontrarAutorPorId(id);

        if (autorEncontrado == null || id == 0) {
            System.out.println("No existe editorial con este ID");
        } else if (autorEncontrado.isAlta()) {
            System.out.println("Tu autor ya está dado de alta");
        } else {
            autorEncontrado.setAlta(Boolean.TRUE);
            autorDao.editar(autorEncontrado);
        }

    }

    public void darDeBajaAutor() throws Exception {

        Integer id = 0;

        try {
                    System.out.println("Ingrese el id del autor que quiere dar de alta:");
        id = SC.nextInt();
        } catch (AutorExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Autor autorEncontrado = autorDao.encontrarAutorPorId(id);

        if (autorEncontrado == null) {
            System.out.println("No existe autor con este ID");
        } else if (autorEncontrado.isAlta()) {
            autorEncontrado.setAlta(Boolean.FALSE);
            autorDao.editar(autorEncontrado);
        } else {
            System.out.println("Tu autor ya está dado de baja");
        }

    }

    public void buscarAutorPorNombre() {

        String nombre;

        System.out.println("Ingrese el nombre del autor que desea buscar");
        nombre = SC.next();

        if(nombre == null || nombre.trim().isEmpty()){
            throw new AutorExcepcion("Ha ingresado un nombre inválido");
        }
        
        List<Autor> autores = autorDao.encontrarAutorPorNombre(nombre);

        if (autores == null) {
            System.out.println("Lo siento, no existe un autor con ese nombre");
        } else {
            autores.forEach((autor) -> {
                System.out.println(autor.toString());
            });
        }

    }

    public Autor traerAutorPorId(int id) {
        Autor autor = autorDao.encontrarAutorPorId(id);
        
        if(autor == null){
            System.out.println("No hay autor con ese ID");
        }
        
        return autor;
    }

}
