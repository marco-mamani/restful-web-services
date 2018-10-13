package duo.code.rest.webservices.resfulwebservices.domain.entity;

import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base implements Serializable, AuditorAware<String> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected int id;

    @Version
    protected Long version;

    @CreatedDate
    protected Date fechaCreacion;

    @CreatedBy
    protected String creadoPor;

    @LastModifiedDate
    protected Date fechaModificacion;

    @LastModifiedBy
    protected String modificadoPor;

    /**
     * Constructor default
     */
    public Base() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @Override
    public String toString()
    {
        System.out.println("RETURn STRING BASE...");
        return "Base{" +
                "id='" + id + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Base)) return false;

        Base that = (Base) obj;

        if (id != that.id) return false;
        return version.equals(that.version);
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        return null;
    }
}
