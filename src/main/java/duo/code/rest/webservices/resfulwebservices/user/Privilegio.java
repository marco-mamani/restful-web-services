package duo.code.rest.webservices.resfulwebservices.user;

import duo.code.rest.webservices.resfulwebservices.domain.entity.Base;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "privilegio")
public class Privilegio extends Base implements Serializable {

    @Size(min = 3, max = 50)
    private String codigo;

    @Size(min = 3, max = 50)
    private String nombre;

    @Size(min = 3, max = 50)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Rol rol;

    /**
     * Constructor default
     */
    public Privilegio() {

    }

    public Privilegio(@Size(min = 3, max = 50) String codigo, @Size(min = 3, max = 50) String nombre, @Size(min = 3, max = 50) String estado, Rol rol) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
