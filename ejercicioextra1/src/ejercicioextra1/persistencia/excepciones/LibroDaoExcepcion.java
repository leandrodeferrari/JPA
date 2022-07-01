package ejercicioextra1.persistencia.excepciones;

public class LibroDaoExcepcion extends RuntimeException{

    public LibroDaoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
