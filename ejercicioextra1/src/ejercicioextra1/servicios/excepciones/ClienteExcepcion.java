package ejercicioextra1.servicios.excepciones;

public class ClienteExcepcion extends RuntimeException{

    public ClienteExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
