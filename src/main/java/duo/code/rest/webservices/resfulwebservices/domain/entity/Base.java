package duo.code.rest.webservices.resfulwebservices.domain.entity;

import org.springframework.data.annotation.*;
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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Date fechaCreacion;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    protected String creadoPor;

    @LastModifiedDate
    @Column(nullable = false)
    protected Date fechaModificacion;

    @LastModifiedBy
    @Column(nullable = false)
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    @Override
    public String toString()
    {
        System.out.println("RETURn STRING BASE...");
        return "Base{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mr. Auditor");
    }
}
