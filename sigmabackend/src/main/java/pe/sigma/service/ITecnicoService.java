package pe.sigma.service;

import java.util.List;


import pe.sigma.model.Tecnico;

public interface ITecnicoService extends ICRUD<Tecnico>{
	
	
	List<String> listarTecnicoheristica(Integer id_solicitud);
}
