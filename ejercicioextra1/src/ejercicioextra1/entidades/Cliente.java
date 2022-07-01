package ejercicioextra1.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "Cliente") 
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer id;
    @Column(name = "DOCUMENTO_DE_IDENTIDAD")
    private Long documentoDeIdentidad;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente() {
    }

    public Cliente(Long documentoDeIdentidad, String nombre, String apellido, String telefono) {
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Cliente(Integer id, Long documentoDeIdentidad, String nombre, String apellido, String telefono) {
        this.id = id;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }

    public void setDocumentoDeIdentidad(Long documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id =" + id + ", documentoDeIdentidad =" + documentoDeIdentidad + ", nombre =" + nombre + ", apellido =" + apellido + ", telefono =" + telefono + '}';
    }

}
