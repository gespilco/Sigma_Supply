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
import pe.sigma.model.OrdenServicioRecurso;
import pe.sigma.service.IOrdenServicioRecursoService;

@RestController
@RequestMapping("/ordenServicioRecursos")
public class OrdenServicioRecursoController {
	@Autowired
	private IOrdenServicioRecursoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdenServicioRecurso>> listar() {
		List<OrdenServicioRecurso> ordenServicioRecursoes = new ArrayList<>();
		ordenServicioRecursoes = service.listar();

		return new ResponseEntity<List<OrdenServicioRecurso>>(ordenServicioRecursoes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<OrdenServicioRecurso> listarId(@PathVariable("id") Integer id) {
		OrdenServicioRecurso ordenServicioRecurso = new OrdenServicioRecurso();
		Optional<OrdenServicioRecurso> ordenServicioRecursoOptional = service.listarId(id);
		if (ordenServicioRecursoOptional.isPresent()) {
			ordenServicioRecurso = ordenServicioRecursoOptional.get();
		}

		Resource<OrdenServicioRecurso> resource = new Resource<OrdenServicioRecurso>(ordenServicioRecurso);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenServicioRecurso> registrar(@Valid @RequestBody OrdenServicioRecurso recurso) {
		OrdenServicioRecurso rec = new OrdenServicioRecurso();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_orden_servicio_recurso())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody OrdenServicioRecurso recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<OrdenServicioRecurso> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
}
