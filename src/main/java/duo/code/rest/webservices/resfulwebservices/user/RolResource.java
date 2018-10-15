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
public class RolResource {

    @Autowired
    private RolRepository rolRepository;


    @RequestMapping(path = "/roles", method = RequestMethod.GET)
    public List<Rol> retrieveAllRoles() {
        return rolRepository.findAll();
    }

    @RequestMapping(path = "/roles/{id}", method = RequestMethod.GET)
    public Resource<Rol> getOneRol(@PathVariable int id) {
        Optional<Rol> rol = rolRepository.findById(id);

        if (!rol.isPresent()) {
            throw new PrivilegioNotFound("id-"+id);//if necesary create another class
        }
        Resource<Rol> resource = new Resource<Rol>(rol.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllRoles());
        resource.add(linkTo.withRel("all-roles"));

        return resource;
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRol(@PathVariable int id) {
        rolRepository.deleteById(id);
    }

    @PostMapping("/roles")
    public ResponseEntity<Rol> createRol(@Valid @RequestBody Rol rol) {
        Rol savedPriv = rolRepository.save(rol);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPriv.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/roles/{id}")
    public ResponseEntity<Rol> updateRol(@Valid @RequestBody Rol newRol, @PathVariable int id) {

        Optional<Rol> rol = rolRepository.findById(id);
        if (!rol.isPresent()) {
            throw new PrivilegioNotFound("id-"+id);//if necessary create another class
        }

        newRol.setId(id);
        rolRepository.save(newRol);

        return ResponseEntity.noContent().build();
    }

}
