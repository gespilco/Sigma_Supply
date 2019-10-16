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
import pe.sigma.model.EstadoSolicitud;
import pe.sigma.service.IEstadoSolicitudService;

@RestController
@RequestMapping("/estadoSolicitudes")
public class EstadoSolicitudController {

	@Autowired
	private IEstadoSolicitudService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadoSolicitud>> listar() {
		List<EstadoSolicitud> estadoSolicitudes = new ArrayList<>();
		estadoSolicitudes = service.listar();

		return new ResponseEntity<List<EstadoSolicitud>>(estadoSolicitudes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<EstadoSolicitud> listarId(@PathVariable("id") Integer id) {
		EstadoSolicitud estadoSol = new EstadoSolicitud();
		Optional<EstadoSolicitud> estadoSolOptional = service.listarId(id);
		if (estadoSolOptional.isPresent()) {
			estadoSol = estadoSolOptional.get();
		}

		Resource<EstadoSolicitud> resource = new Resource<EstadoSolicitud>(estadoSol);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadoSolicitud> registrar(@Valid @RequestBody EstadoSolicitud recurso) {
		EstadoSolicitud rec = new EstadoSolicitud();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getClass())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody EstadoSolicitud recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<EstadoSolicitud> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
}
