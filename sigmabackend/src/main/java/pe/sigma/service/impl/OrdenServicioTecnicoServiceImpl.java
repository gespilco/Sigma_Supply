package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IOrdenServicioTecnicoDao;
import pe.sigma.model.OrdenServicioTecnico;
import pe.sigma.service.IOrdenServicioTecnicoService;

@Service
public class OrdenServicioTecnicoServiceImpl implements IOrdenServicioTecnicoService {

	@Autowired
	private IOrdenServicioTecnicoDao dao;
	
	@Override
	public OrdenServicioTecnico registrar(OrdenServicioTecnico t) {
		return dao.save(t);
	}

	@Override
	public OrdenServicioTecnico modificar(OrdenServicioTecnico t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<OrdenServicioTecnico> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<OrdenServicioTecnico> listar() {
		return dao.findAll();
	}
	@Override
	public List<String> listarOrdenServicioTecnico(Integer id_orden_servicio) {
		return dao.listarOrdenServicioTec(id_orden_servicio);
	}
	
	@Override
	public List<String> objOrdenServicioTecnico(Integer id_orden_servicio,Integer id_tecnico) {
		return dao.objOrdenServicioTec(id_orden_servicio,id_tecnico);
	}

}
