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
import pe.sigma.model.HojaRuta;
import pe.sigma.service.IHojaRutaService;

@RestController
@RequestMapping("/hojaRutas")
public class HojaRutaController {
	@Autowired
	private IHojaRutaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HojaRuta>> listar() {
		List<HojaRuta> hojaRutaes = new ArrayList<>();
		hojaRutaes = service.listar();

		return new ResponseEntity<List<HojaRuta>>(hojaRutaes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Resource<HojaRuta> listarId(@PathVariable("id") Integer id) {
		HojaRuta hojaRuta = new HojaRuta();
		Optional<HojaRuta> hojaRutaOptional = service.listarId(id);
		if (hojaRutaOptional.isPresent()) {
			hojaRuta = hojaRutaOptional.get();
		}

		Resource<HojaRuta> resource = new Resource<HojaRuta>(hojaRuta);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarId(id));
		resource.add(linkTo.withRel("recurso-resource"));

		return resource;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HojaRuta> registrar(@Valid @RequestBody HojaRuta recurso) {
		HojaRuta rec = new HojaRuta();
		rec = service.registrar(recurso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rec.getId_hoja_ruta())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody HojaRuta recurso) {
		service.modificar(recurso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<HojaRuta> recOptional = service.listarId(id);
		if (recOptional.isPresent()) {
			service.eliminar(id);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}
	
	
//	@PostMapping(value = "/verHojaRuta/{id_programa_visita}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<String>> verHojaRuta(
//			@PathVariable("id_programa_visita") Integer id_programa_visita) {
//		List<String> resource = new ArrayList<>();
//		resource = service.verHojaRuta(id_programa_visita);
//
//		return new ResponseEntity<List<String>>(resource, HttpStatus.OK);
//	}
//	
//	
//	@PostMapping(value = "/generarHojaRuta/{id_programa_visita}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<String>> generarHojaRuta(
//			@PathVariable("id_programa_visita") Integer id_programa_visita) {
//		List<String> resource = new ArrayList<>();
//		resource = service.generarHojaRuta(id_programa_visita);
//
//		return new ResponseEntity<List<String>>(resource, HttpStatus.OK);
//	}
	
	@PostMapping(value = "/listarHojaRuta/{id_programa_visita}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> listarHojaRuta(
			@PathVariable("id_programa_visita") Integer id_programa_visita) {
		List<String> resource = new ArrayList<>();
		resource = service.listarHojaRuta(id_programa_visita);

		return new ResponseEntity<List<String>>(resource, HttpStatus.OK);
	}
}
