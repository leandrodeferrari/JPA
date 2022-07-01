package ejercicioextra1.servicios.excepciones;

public class PrestamoExcepcion extends RuntimeException{

    public PrestamoExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
