package pe.sigma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
