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
import pe.sigma.model.ProgramaVisita;
import pe.sigma.service.IProgramaVisitaService;

@RestController
@RequestMapping("/programavisita")
public class ProgramaVisitaController {

	@Autowired
	private IProgramaVisitaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProgramaVisita>> listar() {
		List<ProgramaVisita> ProgramaVisitaes = new ArrayList<>();
		ProgramaVisitaes = service.listar();

		return new ResponseEntity<List<ProgramaVisita>>(ProgramaVisitaes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<ProgramaVisita> listarId(@PathVariable("id") Integer id) {
		ProgramaVisita ProgramaVisita = new ProgramaVisita();
		Optional<ProgramaVisita> ProgramaVisitaOptional = service.listarId(id);
		if (ProgramaVisitaOptional.isPresent()) {
			ProgramaVisita = ProgramaVisitaOptional.get();
		}

		Resource<ProgramaVisita> resource = new Resource<ProgramaVisita>(ProgramaVisita);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProgramaVisita> registrar(@Valid @RequestBody ProgramaVisita recurso) {
		ProgramaVisita rec = new ProgramaVisita();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rec.getId_programa_visita()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody ProgramaVisita recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<ProgramaVisita> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

	@PostMapping(value = "/listarProgramaVisitaPag/{id_tecnico}/{fecha}/{skip}/{take}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarProgramaVisitaPag(
			@PathVariable("id_tecnico") Integer id_tecnico,
			@PathVariable("fecha") String fecha,
			@PathVariable("skip") Integer skip, @PathVariable("take") Integer take) {

		List<String> programaVisita = new ArrayList<>();
		programaVisita = service.listarProgramaVisitaPag(id_tecnico, fecha, skip, take);

		return new ResponseEntity<List<String>>(programaVisita, HttpStatus.OK);


	}

	
}
