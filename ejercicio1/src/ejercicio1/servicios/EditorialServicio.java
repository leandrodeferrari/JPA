package ejercicio1.servicios;

import ejercicio1.entidades.Editorial;
import ejercicio1.persistencia.EditorialDaoExt;
import ejercicio1.persistencia.EditorialJpaController;
import java.util.Scanner;

public class EditorialServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final EditorialDaoExt editorialDao;
    private final EditorialJpaController editorialJpa;

    public EditorialServicio() {
        this.editorialDao = new EditorialDaoExt();
        this.editorialJpa = new EditorialJpaController();
    }

    public Editorial crearEditorial() {

        String nombreEditorial;
        Boolean alta = true;

        System.out.println("Ingrese el nombre de la editorial");
        nombreEditorial = leer.next();

        Editorial editorial = new Editorial(nombreEditorial, alta);

        return editorial;

    }

    public void guardarEditorial() throws Exception{
        Editorial editorial = crearEditorial();
        editorialJpa.create(editorial);
    }
    
    public void darDeAltaLaEditorial() throws Exception {

        Integer id;
        
        System.out.println("Ingrese el id de la editorial que desea dar de alta:");
        id = leer.nextInt();
        
        Editorial editorial1 = editorialJpa.findEditorial(id);

        if (editorial1 == null) {
            throw new NullPointerException("No existe una editorial con ese id");
        } else if (editorial1.isAlta()) {
            throw new RuntimeException("Tu editorial ya está dada de alta");
        } else {
            editorial1.setAlta(Boolean.TRUE);
            editorialJpa.edit(editorial1);
        }

    }

    public void darDeBajaEditorial() throws Exception {

        Integer id;
        
        System.out.println("Ingrese el id de al editorial que desea buscar:");
        id = leer.nextInt();
        
        Editorial editorialEncontrada = editorialJpa.findEditorial(id);

        if (editorialEncontrada == null) {
            throw new NullPointerException("No existe editorial con ese id");
        } else if (editorialEncontrada.isAlta()) {
            editorialEncontrada.setAlta(Boolean.FALSE);
            editorialJpa.edit(editorialEncontrada);
        } else {
            throw new RuntimeException("Tu editorial ya está dada de baja");
        }

    }

}
