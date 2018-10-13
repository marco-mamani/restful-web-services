package duo.code.rest.webservices.resfulwebservices.user;

import duo.code.rest.webservices.resfulwebservices.domain.entity.Persona;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "medico")
public class Medico extends Persona implements Serializable {

    @ApiModelProperty(notes = "epecialidad....")
    private String especialidad;

    @ApiModelProperty(notes = "Curriculum vitae...")
    private String curriculumVitae;

    @ApiModelProperty(notes = "Anios de experiencia.")
    private Integer anosExperiencia;

    @ApiModelProperty(notes = "Mtricula.")
    private String numMatricula;

    public Medico() {
    }

    public Medico(String especialidad, String curriculumVitae, Integer anosExperiencia, String numMatricula) {
        super();
        this.especialidad = especialidad;
        this.curriculumVitae = curriculumVitae;
        this.anosExperiencia = anosExperiencia;
        this.numMatricula = numMatricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCurriculumVitae() {
        return curriculumVitae;
    }

    public void setCurriculumVitae(String curriculumVitae) {
        this.curriculumVitae = curriculumVitae;
    }

    public Integer getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(Integer anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }
}
