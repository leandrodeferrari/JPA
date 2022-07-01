package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Cliente;
import ejercicioextra1.persistencia.ClienteDAO;
import java.util.Scanner;

public class ClienteServicio {
    
    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final ClienteDAO CLIENTE_DAO;

    public ClienteServicio() {
        this.CLIENTE_DAO = new ClienteDAO();
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
    
    public void ingresarCliente(){
        
        Cliente cliente = crearCliente();
        
        if(cliente != null){
            CLIENTE_DAO.guardar(cliente);
        } else if(cliente == null){
            throw new NullPointerException("No ha cargado correctamente el cliente");
        }
        
    }
 
    public void ingresarCliente(Cliente cliente){
        
        if(cliente != null){
            CLIENTE_DAO.guardar(cliente);
        } else if(cliente == null){
            throw new NullPointerException("No ha cargado correctamente el cliente");
        }
        
    }
    
}
