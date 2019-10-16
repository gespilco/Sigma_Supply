package pe.sigma.service;

import java.util.List;

import pe.sigma.model.OrdenServicioTecnico;

public interface IOrdenServicioTecnicoService extends ICRUD<OrdenServicioTecnico> {

	List<String> listarOrdenServicioTecnico(Integer id_orden_servicio);

	List<String> objOrdenServicioTecnico(Integer id_orden_servicio, Integer id_tecnico);

}
