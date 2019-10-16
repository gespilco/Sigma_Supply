package pe.sigma.service;

import java.util.List;

import pe.sigma.model.ParametroSistema;

public interface IParametroSistemaService  extends ICRUD<ParametroSistema>{

	List<String> listarParametroSistemaTec(Integer id_solicitud);

}
