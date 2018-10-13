package duo.code.rest.webservices.resfulwebservices.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "persona" )
public class Persona extends Base {

    @Size(min = 3, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Size(min = 3, max = 50)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Size(max = 50)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Size(max = 10)
    @Column(name = "genero")
    private String genero;

    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;

    @Size(max = 20)
    @Column(name = "celular")
    private String celular;

    @Size(max = 15)
    @Column(name = "ci")
    private String ci;

    @Size(max = 80)
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 50)
    @Column(name = "correo_electronico")
    private String correo;

    @Column(name = "activo")
    private boolean activo;

    /**
     * Constructor default
     */
    public Persona() {

    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Boolean activo) {
//        super();
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.activo = activo;
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String genero, String telefono, String celular, String ci, String direccion, String correo, boolean activo) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.telefono = telefono;
        this.celular = celular;
        this.ci = ci;
        this.direccion = direccion;
        this.correo = correo;
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public boolean isEstado() {
        return activo;
    }

    public void setEstado(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public String getCi() {
        return ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
