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
import pe.sigma.model.ParametroSistema;
import pe.sigma.service.IParametroSistemaService;

@RestController
@RequestMapping("/parametroSistema")
public class ParametroSistemaController {
	
	@Autowired
	private IParametroSistemaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParametroSistema>> listar() {
		List<ParametroSistema> ParametroSistemas = new ArrayList<>();
		ParametroSistemas = service.listar();

		return new ResponseEntity<List<ParametroSistema>>(ParametroSistemas, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<ParametroSistema> listarId(@PathVariable("id") Integer id) {
		ParametroSistema ParametroSistema = new ParametroSistema();
		Optional<ParametroSistema> ParametroSistemaOptional = service.listarId(id);
		if (ParametroSistemaOptional.isPresent()) {
			ParametroSistema = ParametroSistemaOptional.get();
		}

		Resource<ParametroSistema> resource = new Resource<ParametroSistema>(ParametroSistema);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ParametroSistema> registrar(@Valid @RequestBody ParametroSistema recurso) {
		ParametroSistema rec = new ParametroSistema();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_parametro_sistema())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody ParametroSistema recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<ParametroSistema> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
	
	@PostMapping(value = "/listarParametroSistemaTec/{id_solicitud}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarParametroSistemaTec(@PathVariable("id_solicitud") Integer id_solicitud){
		List<String> parametroServicio = new ArrayList<>();
		parametroServicio = service.listarParametroSistemaTec(id_solicitud);

		return new ResponseEntity<List<String>>(parametroServicio, HttpStatus.OK);
	}
}
