package ejercicio1.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Editorial")
public class Editorial implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private Integer id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "alta")
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Editorial(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean isAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Editorial other = (Editorial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Editorial{" + "id =" + id + ", nombre =" + nombre + ", alta =" + alta + '}';
    }
    
}
