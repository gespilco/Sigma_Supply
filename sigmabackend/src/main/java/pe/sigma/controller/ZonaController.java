package pe.sigma.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.sigma.exception.ModeloNotFoundException;
import pe.sigma.model.Zona;
import pe.sigma.service.IZonaService;

@RestController
@RequestMapping("/zonas")
public class ZonaController {

	@Autowired
	private IZonaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Zona>> listar() {
		List<Zona> zonas = new ArrayList<>();
		zonas = service.listar();

		return new ResponseEntity<List<Zona>>(zonas, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<Zona> listarId(@PathVariable("id") Integer id) {
		Zona rec = new Zona();
		Optional<Zona> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			rec = recOptional.get();
		}

		Resource<Zona> resource = new Resource<Zona>(rec);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("zona-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zona> registrar(@Valid @RequestBody Zona zona) {
		Zona rec = new Zona();
		rec = service.registrar(zona);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_zona())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Zona zona) {
		service.modificar(zona);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Zona> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
}
