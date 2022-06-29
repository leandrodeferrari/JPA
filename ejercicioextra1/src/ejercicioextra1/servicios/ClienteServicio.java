package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Cliente;
import ejercicioextra1.persistencia.ClienteDAO;
import java.util.Scanner;

public class ClienteServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private ClienteDAO clienteDao;

    public ClienteServicio() {
        this.clienteDao = new ClienteDAO();
    }
    
    public Cliente crearCliente(){
        
        Long documentoIdentidad;
        String nombre, apellido, telefono;
        
        System.out.println("Ingrese el documento de identidad del cliente:");
        documentoIdentidad = SC.nextLong();
        
        System.out.println("Ingrese el nombre del cliente:");
        nombre = SC.next();
        
        System.out.println("Ingrese el apellido del cliente:");
        apellido = SC.next();
        
        System.out.println("Ingrese el teléfono del cliente:");
        telefono = SC.next();
        
        return new Cliente(documentoIdentidad, nombre, apellido, telefono);
        
    }
    
}
