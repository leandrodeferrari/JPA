package ejercicioextra1.persistencia.excepciones;

public class PrestamoDaoExcepcion extends RuntimeException{

    public PrestamoDaoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
