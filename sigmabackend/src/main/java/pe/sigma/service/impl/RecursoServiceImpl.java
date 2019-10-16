package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IRecursoDao;
import pe.sigma.model.Recurso;
import pe.sigma.service.IRecursoService;

@Service
public class RecursoServiceImpl implements IRecursoService {

	@Autowired
	private IRecursoDao dao;

	@Override
	public Recurso registrar(Recurso t) {
		return dao.save(t);
	}

	@Override
	public Recurso modificar(Recurso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Recurso> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Recurso> listar() {
		return dao.findAll();
	}

}
