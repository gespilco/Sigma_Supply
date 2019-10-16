package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IOrdenServicioRecursoDao;
import pe.sigma.model.OrdenServicioRecurso;
import pe.sigma.service.IOrdenServicioRecursoService;

@Service
public class OrdenServicioRecursoServiceImpl implements IOrdenServicioRecursoService {

	@Autowired
	private IOrdenServicioRecursoDao dao;
	
	@Override
	public OrdenServicioRecurso registrar(OrdenServicioRecurso t) {
		return dao.save(t);
	}

	@Override
	public OrdenServicioRecurso modificar(OrdenServicioRecurso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<OrdenServicioRecurso> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<OrdenServicioRecurso> listar() {
		return dao.findAll();
	}

}
