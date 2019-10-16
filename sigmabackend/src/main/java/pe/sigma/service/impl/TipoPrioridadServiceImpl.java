package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.ITipoPrioridadDao;
import pe.sigma.model.TipoPrioridad;
import pe.sigma.service.ITipoPrioridadService;


@Service
public class TipoPrioridadServiceImpl implements ITipoPrioridadService {
	@Autowired
	private ITipoPrioridadDao dao;
	
	@Override
	public TipoPrioridad registrar(TipoPrioridad t) {
		return dao.save(t);
	}

	@Override
	public TipoPrioridad modificar(TipoPrioridad t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<TipoPrioridad> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<TipoPrioridad> listar() {
		return dao.findAll();
	}
}
