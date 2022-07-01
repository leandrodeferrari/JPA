package ejercicioextra1.servicios;

import ejercicioextra1.entidades.*;
import ejercicioextra1.persistencia.*;
import ejercicioextra1.servicios.excepciones.PrestamoExcepcion;
import java.util.*;

public class PrestamoServicio {

    private final Scanner SC = new Scanner(System.in).useDelimiter("\n");
    private final PrestamoDAO PRESTAMO_DAO;

    public PrestamoServicio() {
        this.PRESTAMO_DAO = new PrestamoDAO();
    }

    public Prestamo crearPrestamo() {

        Date fechaPrestamo, fechaDevolucion;
        int anio, mes, dia;
        Long isbn;
        Integer idCliente;
        Libro libro;
        Cliente cliente;
        LibroDAO libroDao = new LibroDAO();
        ClienteDAO clienteDao = new ClienteDAO();

        try {
            System.out.println("Ingrese la fecha inicial del préstamo:");
            System.out.println("Año (AAAA):");
            anio = SC.nextInt();
            System.out.println("Mes (MM):");
            mes = SC.nextInt();
            System.out.println("Día (DD):");
            dia = SC.nextInt();
            fechaPrestamo = new Date(anio - 1900, mes - 1, dia);

            System.out.println("Ingrese la fecha de devolución del préstamo:");
            System.out.println("Año (AAAA):");
            anio = SC.nextInt();
            System.out.println("Mes (MM):");
            mes = SC.nextInt();
            System.out.println("Día (DD):");
            dia = SC.nextInt();
            fechaDevolucion = new Date(anio - 1900, mes - 1, dia);
        } catch (PrestamoExcepcion ex) {
            throw new PrestamoExcepcion("Ha ingresado un valor de fecha inválido");
        }

        try {
            System.out.println("Ingrese el ISBN del libro:");
            isbn = SC.nextLong();

            libro = libroDao.encontrarLibroPorIsbn(isbn);
            if (libro.getEjemplaresRestantes() != 0) {
                libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
                libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
                libroDao.editar(libro);
            } else {
                System.out.println("Lo siento, el libro " + libro.getTitulo() + " no posee más ejemplares para prestar");
                return new Prestamo();
            }
        } catch (NullPointerException ex) {
            LibroServicio libroServicio = new LibroServicio();
            libro = libroServicio.crearLibro();
            libro.setEjemplaresPrestados(libro.getEjemplaresPrestados() + 1);
            libro.setEjemplaresRestantes(libro.getEjemplaresRestantes() - 1);
            libroServicio.ingresarLibro(libro);
        }

        System.out.println("Ingrese el ID del cliente:");
        idCliente = SC.nextInt();

        try {
            cliente = clienteDao.encontrarClientePorId(idCliente);
        } catch (NullPointerException ex) {
            ClienteServicio clienteServicio = new ClienteServicio();
            cliente = clienteServicio.crearCliente();
            clienteServicio.ingresarCliente(cliente);
        }

        return new Prestamo(fechaPrestamo, fechaDevolucion, libro, cliente);

    }

    public void ingresarPrestamo() {

        Prestamo prestamo = crearPrestamo();

        if (prestamo != null) {
            PRESTAMO_DAO.guardar(prestamo);
        } else {
            throw new PrestamoExcepcion("No ha cargado correctamente el préstamo");
        }

    }

    public void mostrarPrestamosDeUnCliente() {

        Integer idCliente;

        System.out.println("Ingrese el ID del cliente que desea buscar sus préstamos:");
        idCliente = SC.nextInt();

        if(idCliente == null){
            throw new PrestamoExcepcion("Ha ingresado un valor inválido");
        }
        
        List<Prestamo> prestamos = PRESTAMO_DAO.consultarPrestamosDeUnCliente(idCliente);

        if (!prestamos.isEmpty()) {
            prestamos.forEach((prestamo) -> {
                System.out.println(prestamo);
            });
        } else if (prestamos.isEmpty()) {
            System.out.println("No hay prestamos con ese ID de cliente");
        } else if (prestamos == null) {
            throw new PrestamoExcepcion("Ocurrió un error al querer buscar clientes, que tengan un préstamo");
        }

    }

}
