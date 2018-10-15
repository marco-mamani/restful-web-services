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
public class PrivilegioResource {

    @Autowired
    PrivilegioRepository privilegioRepository;

    @RequestMapping(path = "/privilegios", method = RequestMethod.GET)
    public List<Privilegio> retrieveAllPrivilegios() {
        return privilegioRepository.findAll();
    }

    @RequestMapping(path = "/privilegios/{id}", method = RequestMethod.GET)
    public Resource<Privilegio> getOnePrivilegio(@PathVariable int id) {
        Optional<Privilegio> privilegio = privilegioRepository.findById(id);

        if (!privilegio.isPresent()) {
            throw new PrivilegioNotFound("id-"+id);
        }
        Resource<Privilegio> resource = new Resource<Privilegio>(privilegio.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllPrivilegios());
        resource.add(linkTo.withRel("all-privilegios"));

        return resource;
    }

    @DeleteMapping("/privilegios/{id}")
    public void deletePrivilegio(@PathVariable int id) {
        privilegioRepository.deleteById(id);
    }

    @PostMapping("/privilegios")
    public ResponseEntity<Privilegio> createMedico(@Valid @RequestBody Privilegio privilegio) {
        Privilegio savedPriv = privilegioRepository.save(privilegio);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPriv.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/privilegios/{id}")
    public ResponseEntity<Privilegio> updatePrivilegio(@Valid @RequestBody Privilegio newPrivilegio, @PathVariable int id) {

        Optional<Privilegio> privilegio = privilegioRepository.findById(id);
        if (!privilegio.isPresent()) {
            throw new PrivilegioNotFound("id-"+id);
        }

        newPrivilegio.setId(id);
        privilegioRepository.save(newPrivilegio);

        return ResponseEntity.noContent().build();
    }

}
