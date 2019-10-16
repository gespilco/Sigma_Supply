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
import pe.sigma.model.EncuestaAtencionServicio;
import pe.sigma.service.IEncuestaAtencionServicioService;

@RestController
@RequestMapping("/encuestas")
public class EncuestaAtencionServicioController {
	@Autowired
	private IEncuestaAtencionServicioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EncuestaAtencionServicio>> listar() {
		List<EncuestaAtencionServicio> encuestaes = new ArrayList<>();
		encuestaes = service.listar();

		return new ResponseEntity<List<EncuestaAtencionServicio>>(encuestaes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<EncuestaAtencionServicio> listarId(@PathVariable("id") Integer id) {
		EncuestaAtencionServicio encuesta = new EncuestaAtencionServicio();
		Optional<EncuestaAtencionServicio> encuestaOptional = service.listarId(id);
		if (encuestaOptional.isPresent()) {
			encuesta = encuestaOptional.get();
		}

		Resource<EncuestaAtencionServicio> resource = new Resource<EncuestaAtencionServicio>(encuesta);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EncuestaAtencionServicio> registrar(@Valid @RequestBody EncuestaAtencionServicio recurso) {
		EncuestaAtencionServicio rec = new EncuestaAtencionServicio();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_encuesta_atencion_servicio())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody EncuestaAtencionServicio recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<EncuestaAtencionServicio> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
}
