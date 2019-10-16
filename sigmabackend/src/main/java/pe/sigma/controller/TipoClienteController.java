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
import pe.sigma.model.TipoCliente;
import pe.sigma.service.ITipoClienteService;

@RestController
@RequestMapping("/tipoClientes")
public class TipoClienteController {

	@Autowired
	private ITipoClienteService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCliente>> listar() {
		List<TipoCliente> tipoClientes = new ArrayList<>();
		tipoClientes = service.listar();

		return new ResponseEntity<List<TipoCliente>>(tipoClientes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<TipoCliente> listarId(@PathVariable("id") Integer id) {
		TipoCliente rec = new TipoCliente();
		Optional<TipoCliente> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			rec = recOptional.get();
		}

		Resource<TipoCliente> resource = new Resource<TipoCliente>(rec);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("tipoCliente-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCliente> registrar(@Valid @RequestBody TipoCliente tipoCliente) {
		TipoCliente rec = new TipoCliente();
		rec = service.registrar(tipoCliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_tipo_cliente())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody TipoCliente tipoCliente) {
		service.modificar(tipoCliente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<TipoCliente> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
}
