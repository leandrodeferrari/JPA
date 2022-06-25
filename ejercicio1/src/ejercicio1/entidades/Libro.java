package ejercicio1.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Libro")
public class Libro implements Serializable{
    
    @Id
    private Long isbn;
    @Basic
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    @Column(name = "ejemplares_prestados")
    private Integer ejemplaresPrestados;
    @Column(name = "ejemplares_restantes")
    private Integer ejemplaresRestantes;
    private boolean alta;
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String titulo, Integer anio, Integer ejemplares, boolean alta, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = 0;
        this.ejemplaresRestantes = this.ejemplares;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }
    
    public Libro(String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.isbn);
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
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Libro{" + "isbn =" + isbn + ", titulo =" + titulo + ", anio =" + anio + ", ejemplares =" + ejemplares + ", ejemplaresPrestados =" + ejemplaresPrestados + ", ejemplaresRestantes =" + ejemplaresRestantes + ", alta =" + alta + ", autor =" + autor.toString() + ", editorial =" + editorial.toString() + '}';
    }
    
}
