package ejercicio1.servicios;

import ejercicio1.entidades.Editorial;
import ejercicio1.persistencia.EditorialDAO;
import ejercicio1.servicios.excepciones.EditorialExcepcion;
import java.util.Scanner;

public class EditorialServicio {

    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final EditorialDAO editorialDao;

    public EditorialServicio() {
        this.editorialDao = new EditorialDAO();
    }

    public Editorial crearEditorial() {

        String nombreEditorial;
        Boolean alta = true;

        System.out.println("Ingrese el nombre de la editorial");
        nombreEditorial = SC.next();

        if (nombreEditorial == null || nombreEditorial.trim().isEmpty()) {
            throw new EditorialExcepcion("No ha ingresado un nombre válido");
        }

        return new Editorial(nombreEditorial, alta);

    }

    public Editorial guardarEditorial() throws Exception {
        Editorial editorial = crearEditorial();

        if (editorial == null) {
            throw new EditorialExcepcion("No ha ingresado una editorial válida");
        }
        editorialDao.guardar(editorial);

        return editorial;
    }

    public void darDeAltaLaEditorial() throws Exception {

        Integer id = 0;

        try {
            System.out.println("Ingrese el id de la editorial que desea dar de alta:");
            id = SC.nextInt();
        } catch (EditorialExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Editorial editorial = editorialDao.encontrarEditorialPorId(id);

        if (editorial == null || id == 0) {
            System.out.println("No existe una editorial con ese ID");
        } else if (editorial.isAlta()) {
            System.out.println("Tu editorial ya está dada de alta");
        } else {
            editorial.setAlta(Boolean.TRUE);
            editorialDao.editar(editorial);
        }

    }

    public void darDeBajaLaEditorial() throws Exception {

        Integer id = 0;

        try {
            System.out.println("Ingrese el id de al editorial que desea buscar:");
            id = SC.nextInt();
        } catch (EditorialExcepcion ex) {
            ex.printStackTrace(System.out);
        }

        Editorial editorialEncontrada = editorialDao.encontrarEditorialPorId(id);

        if (editorialEncontrada == null) {
            System.out.println("No existe editorial con este ID");
        } else if (editorialEncontrada.isAlta()) {
            editorialEncontrada.setAlta(Boolean.FALSE);
            editorialDao.editar(editorialEncontrada);
        } else {
            System.out.println("Tu editorial ya está dada de baja");
        }

    }

    public Editorial traerAutorPorId(int id) {
        Editorial editorial = editorialDao.encontrarEditorialPorId(id);
        
        if(editorial == null){
            System.out.println("No existe editorial con ese ID");
        }
        
        return editorial;
    }

}
