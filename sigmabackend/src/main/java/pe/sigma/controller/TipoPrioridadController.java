package pe.sigma.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import pe.sigma.model.TipoPrioridad;
import pe.sigma.service.ITipoPrioridadService;

@RestController
@RequestMapping("/tipoPrioridades")
public class TipoPrioridadController {
	@Autowired
	private ITipoPrioridadService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoPrioridad>> listar() {
		List<TipoPrioridad> tipoPrioridades = new ArrayList<>();
		tipoPrioridades = service.listar();

		return new ResponseEntity<List<TipoPrioridad>>(tipoPrioridades, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<TipoPrioridad> listarId(@PathVariable("id") Integer id) {
		TipoPrioridad rec = new TipoPrioridad();
		Optional<TipoPrioridad> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			rec = recOptional.get();
		}

		Resource<TipoPrioridad> resource = new Resource<TipoPrioridad>(rec);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("tipoPrioridad-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoPrioridad> registrar(@Valid @RequestBody TipoPrioridad tipoPrioridad) {
		TipoPrioridad rec = new TipoPrioridad();
		rec = service.registrar(tipoPrioridad);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_tipo_prioridad())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody TipoPrioridad tipoPrioridad) {
		service.modificar(tipoPrioridad);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<TipoPrioridad> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

}
