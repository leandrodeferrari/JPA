package ejercicioextra1.servicios;

import ejercicioextra1.entidades.Cliente;
import ejercicioextra1.persistencia.ClienteDAO;
import ejercicioextra1.servicios.excepciones.ClienteExcepcion;
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
        
        try {
            System.out.println("Ingrese el documento de identidad del cliente:");
        documentoIdentidad = SC.nextLong();
        } catch (ClienteExcepcion ex) {
            throw new ClienteExcepcion("Ha ingresado un valor inválido");
        }
        
        System.out.println("Ingrese el nombre del cliente:");
        nombre = SC.next();
        
        if(nombre == null || nombre.isEmpty()){
            throw new ClienteExcepcion("Ha ingresado un nombre inválido");
        }
        
        System.out.println("Ingrese el apellido del cliente:");
        apellido = SC.next();
        
        if(apellido == null || nombre.isEmpty()){
            throw new ClienteExcepcion("Ha ingresado un apellido inválido");
        }
        
        System.out.println("Ingrese el teléfono del cliente:");
        telefono = SC.next();
        
        if(telefono == null || nombre.isEmpty()){
            throw new ClienteExcepcion("Ha ingresado un teléfono inválido");
        }
        
        return new Cliente(documentoIdentidad, nombre, apellido, telefono);
        
    }
    
    public void ingresarCliente(){
        
        Cliente cliente = crearCliente();
        
        if(cliente != null){
            CLIENTE_DAO.guardar(cliente);
        } else if(cliente == null){
            throw new ClienteExcepcion("No ha cargado correctamente el cliente");
        }
        
    }
 
    public void ingresarCliente(Cliente cliente){
        
        if(cliente != null){
            CLIENTE_DAO.guardar(cliente);
        } else if(cliente == null){
            throw new ClienteExcepcion("No ha cargado correctamente el cliente");
        }
        
    }
    
}
