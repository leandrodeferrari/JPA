package ejercicioextra1.persistencia.excepciones;

public class ClienteDaoExcepcion extends RuntimeException{

    public ClienteDaoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
