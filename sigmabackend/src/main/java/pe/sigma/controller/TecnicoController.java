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
import pe.sigma.model.Tecnico;
import pe.sigma.service.ITecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

	@Autowired
	private ITecnicoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tecnico>> listar() {
		List<Tecnico> tecnicos = new ArrayList<>();
		tecnicos = service.listar();

		return new ResponseEntity<List<Tecnico>>(tecnicos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<Tecnico> listarId(@PathVariable("id") Integer id) {
		Tecnico rec = new Tecnico();
		Optional<Tecnico> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			rec = recOptional.get();
		}

		Resource<Tecnico> resource = new Resource<Tecnico>(rec);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("tecnico-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tecnico> registrar(@Valid @RequestBody Tecnico tecnico) {
		Tecnico rec = new Tecnico();
		rec = service.registrar(tecnico);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rec.getId_tecnico()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Tecnico tecnico) {
		service.modificar(tecnico);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Tecnico> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

	@GetMapping(value = "/listarTecnicoHeuristica/{id_solicitud}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarTecnicoHeuristica(@PathVariable("id_solicitud") Integer id_solicitud) {
		List<String> tecnicos = new ArrayList<>();
		tecnicos = service.listarTecnicoheristica(id_solicitud);

		return new ResponseEntity<List<String>>(tecnicos, HttpStatus.OK);
	}
}
