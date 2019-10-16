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
import pe.sigma.model.OrdenServicio;
import pe.sigma.service.IOrdenServicioService;

@RestController
@RequestMapping("/ordenServicios")
public class OrdenServicioController {
	@Autowired
	private IOrdenServicioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdenServicio>> listar() {
		List<OrdenServicio> ordenServicioes = new ArrayList<>();
		ordenServicioes = service.listar();

		return new ResponseEntity<List<OrdenServicio>>(ordenServicioes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<OrdenServicio> listarId(@PathVariable("id") Integer id) {
		OrdenServicio ordenServicio = new OrdenServicio();
		Optional<OrdenServicio> ordenServicioOptional = service.listarId(id);
		if (ordenServicioOptional.isPresent()) {
			ordenServicio = ordenServicioOptional.get();
		}

		Resource<OrdenServicio> resource = new Resource<OrdenServicio>(ordenServicio);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenServicio> registrar(@Valid @RequestBody OrdenServicio recurso) {
		OrdenServicio rec = new OrdenServicio();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rec.getId_orden_servicio()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody OrdenServicio recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<OrdenServicio> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

	@PostMapping(value = "/listarOrdenServicio/{id_orden_servicio}/{fecha_recepcion}/{id_tipo_solicitud}/{id_estado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarOrdenServicio(
			@PathVariable("id_orden_servicio") Integer id_orden_servicio,
			@PathVariable("fecha_recepcion") String fecha_recepcion,
			@PathVariable("id_tipo_solicitud") Integer id_tipo_solicitud,
			@PathVariable("id_estado") Integer id_estado) {
		List<String> ordenServicio = new ArrayList<>();
		ordenServicio = service.listarOrdenServicio(id_orden_servicio, fecha_recepcion, id_tipo_solicitud, id_estado);

		return new ResponseEntity<List<String>>(ordenServicio, HttpStatus.OK);
	}

	@PostMapping(value = "/listarOrdenServicioPag/{id_orden_servicio}/{fecha_recepcion}/{id_tipo_solicitud}/{id_estado}/{skip}/{take}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarOrdenServicioPag(
			@PathVariable("id_orden_servicio") Integer id_orden_servicio,
			@PathVariable("fecha_recepcion") String fecha_recepcion,
			@PathVariable("id_tipo_solicitud") Integer id_tipo_solicitud, @PathVariable("id_estado") Integer id_estado,
			@PathVariable("skip") Integer skip, @PathVariable("take") Integer take) {
		List<String> ordenServicio = new ArrayList<>();
		ordenServicio = service.listarOrdenServicioPag(id_orden_servicio, fecha_recepcion, id_tipo_solicitud, id_estado,
				skip, take);

		return new ResponseEntity<List<String>>(ordenServicio, HttpStatus.OK);
	}
	
	@PostMapping(value = "/listarOrdenServicioPagNum/{numero_orden}/{fecha_recepcion}/{id_tipo_solicitud}/{id_estado}/{skip}/{take}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarOrdenServicioPagNum(
			@PathVariable("numero_orden") String numero_orden,
			@PathVariable("fecha_recepcion") String fecha_recepcion,
			@PathVariable("id_tipo_solicitud") Integer id_tipo_solicitud, @PathVariable("id_estado") Integer id_estado,
			@PathVariable("skip") Integer skip, @PathVariable("take") Integer take) {
		List<String> ordenServicio = new ArrayList<>();
		ordenServicio = service.listarOrdenServicioPagNum(numero_orden, fecha_recepcion, id_tipo_solicitud, id_estado,skip, take);

		return new ResponseEntity<List<String>>(ordenServicio, HttpStatus.OK);
	}

}
