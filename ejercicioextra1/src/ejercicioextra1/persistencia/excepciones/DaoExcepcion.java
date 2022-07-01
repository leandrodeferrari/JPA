package ejercicioextra1.persistencia.excepciones;

public class DaoExcepcion extends RuntimeException{

    public DaoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
