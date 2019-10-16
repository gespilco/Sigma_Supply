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
import pe.sigma.model.OrdenServicioTecnico;
import pe.sigma.service.IOrdenServicioTecnicoService;

@RestController
@RequestMapping("/ordenServicioTecnicos")
public class OrdenServicioTecnicoController {
	@Autowired
	private IOrdenServicioTecnicoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdenServicioTecnico>> listar() {
		List<OrdenServicioTecnico> ordenServicioTecnicos = new ArrayList<>();
		ordenServicioTecnicos = service.listar();

		return new ResponseEntity<List<OrdenServicioTecnico>>(ordenServicioTecnicos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<OrdenServicioTecnico> listarId(@PathVariable("id") Integer id) {
		OrdenServicioTecnico ordenServicioTecnico = new OrdenServicioTecnico();
		Optional<OrdenServicioTecnico> ordenServicioTecnicoOptional = service.listarId(id);
		if (ordenServicioTecnicoOptional.isPresent()) {
			ordenServicioTecnico = ordenServicioTecnicoOptional.get();
		}

		Resource<OrdenServicioTecnico> resource = new Resource<OrdenServicioTecnico>(ordenServicioTecnico);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenServicioTecnico> registrar(@Valid @RequestBody OrdenServicioTecnico recurso) {
		OrdenServicioTecnico rec = new OrdenServicioTecnico();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rec.getId_orden_servicio_tecnico()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody OrdenServicioTecnico recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<OrdenServicioTecnico> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

	@GetMapping(value = "/listarOrdenServicioTecnico/{id_orden_servicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarOrdenServicioTecnico(
			@PathVariable("id_orden_servicio") Integer id_orden_servicio) {
		List<String> ordenServicioTecnicos = new ArrayList<>();
		ordenServicioTecnicos = service.listarOrdenServicioTecnico(id_orden_servicio);

		return new ResponseEntity<List<String>>(ordenServicioTecnicos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/objOrdenServicioTecnico/{id_orden_servicio}/{id_tecnico}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> objOrdenServicioTecnico(@PathVariable("id_orden_servicio") Integer id_orden_servicio,@PathVariable("id_tecnico") Integer id_tecnico) {
		List<String> ordenServicioTecnicos = new ArrayList<>();
		ordenServicioTecnicos = service.objOrdenServicioTecnico(id_orden_servicio,id_tecnico);

		return new ResponseEntity<List<String>>(ordenServicioTecnicos, HttpStatus.OK);
	}
	
}
