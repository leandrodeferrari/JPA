package ejercicioextra1;

import ejercicioextra1.presentacion.Menu;

public class EjercicioExtra1 {

    public static void main(String[] args) {
        
        /*
        
        1. Sistema de Reservas de una Librería
        
        Vamos a continuar con el ejercicio anterior. Ahora el objetivo de este ejercicio es el 
        desarrollo de un sistema de reserva de libros en JAVA. Para esto vamos a tener que 
        sumar nuevas entidades a nuestro proyecto en el paquete de entidades y crearemos los 
        servicios de esas entidades. 
        
        Usaremos la misma base de datos y se van a crear las tablas que nos faltan. Deberemos 
        agregar las entidades a la unidad de persistencia.
        
        a) Entidades 
        
        Crearemos el siguiente modelo de entidades: 
        
        Entidad Cliente
        
        La entidad cliente modela los clientes (a quienes se les presta libros) de la biblioteca. Se 
        almacenan los datos personales y de contacto de ese cliente. 
        
        Entidad Préstamo 
        
        La entidad préstamo modela los datos de un préstamo de un libro. Esta entidad registra 
        la fecha en la que se efectuó el préstamo y la fecha en la que se devolvió el libro. Esta 
        entidad también registra el libro que se llevo en dicho préstamo y quien fue el cliente al 
        cual se le prestaron. 
        
        b) Servicios 
        
        ClienteServicio 
        
        Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias 
        para administrar clientes (consulta, creación, modificación y eliminación).
        
        PrestamoServicio 
        
        Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias 
        para generar prestamos, va a guardar la información del cliente y del libro para persistirla 
        en la base de datos. (consulta, creación, modificación y eliminación).
        
        c) Tareas a Realizar 
        
        Al alumno le toca desarrollar, las siguientes funcionalidades: 
        
        1. Creación de un Cliente nuevo
        2. Crear entidad Préstamo
        3. Registrar el préstamo de un libro.
        4. Devolución de un libro
        5. Búsqueda de todos los prestamos de un Cliente.
        6. Agregar validaciones a todas las funcionalidades de la aplicación:
        a) Validar campos obligatorios.
        b) No ingresar datos duplicados. 
        c) No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más 
        ejemplares de los que hay, ni devolver más de los que se encuentran prestados. 
        No se podrán prestar libros con fecha anterior a la fecha actual, etc.
        
        */
        
        Menu menu = new Menu();
        menu.ejecutarMenu();
        
    }
    
}
