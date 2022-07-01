package ejercicioextra1.persistencia.excepciones;

public class AutorDaoExcepcion extends RuntimeException{

    public AutorDaoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
