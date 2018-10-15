package duo.code.rest.webservices.resfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class MedicoResource {

    @Autowired
    private MedicoRepository medicoRepository;

    @RequestMapping(path = "/medicos", method = RequestMethod.GET)
    public List<Medico> retrieveAllMedicos() {
        return medicoRepository.findAll();
    }

    @RequestMapping(path = "/medicos/{id}", method = RequestMethod.GET)
    public Resource<Medico> getOneMedico(@PathVariable int id) {
        Optional<Medico> medico = medicoRepository.findById(id);

        if (!medico.isPresent()) {
            throw new MedicoNotFound("id-"+id);
        }
        Resource<Medico> resource = new Resource<Medico>(medico.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllMedicos());
        resource.add(linkTo.withRel("all-medicos"));

        return resource;
    }

    @DeleteMapping("/medicos/{id}")
    public void deleteMedico(@PathVariable int id) {
        medicoRepository.deleteById(id);
    }

    @PostMapping("/medicos")
    public ResponseEntity<Medico> createMedico(@Valid @RequestBody Medico medico) {
        Medico savedMedico = medicoRepository.save(medico);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMedico.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/medicos/{id}")
    public ResponseEntity<Medico> updateMedico(@Valid @RequestBody Medico newMedico, @PathVariable int id) {

        Optional<Medico> medico = medicoRepository.findById(id);
        if (!medico.isPresent()) {
            throw new MedicoNotFound("id-"+id);
        }

        newMedico.setId(id);
        medicoRepository.save(newMedico);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        return ResponseEntity.noContent().build();
    }

}
