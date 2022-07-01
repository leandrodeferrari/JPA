package ejercicioextra1.persistencia.excepciones;

public class EditorialDaoExcepcion extends RuntimeException{

    public EditorialDaoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
