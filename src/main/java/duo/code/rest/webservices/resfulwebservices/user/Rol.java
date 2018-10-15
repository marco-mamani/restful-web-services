package duo.code.rest.webservices.resfulwebservices.user;

import duo.code.rest.webservices.resfulwebservices.domain.entity.Base;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rol")
public class Rol extends Base implements Serializable {

    @Size(min = 3, max = 50)
    private String nombre;

    @Size(min = 3, max = 50)
    private String codigo;

    @Size(max = 50)
    private String estado;

    @OneToMany(mappedBy = "rol") //name of the field in Privilegio
    private List<Privilegio> privilegios;

    public Rol() {
    }

    public Rol(@Size(min = 3, max = 50) String nombre, @Size(min = 3, max = 50) String codigo, @Size(max = 50) String estado, List<Privilegio> privilegios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.privilegios = privilegios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Privilegio> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(List<Privilegio> privilegios) {
        this.privilegios = privilegios;
    }
}
