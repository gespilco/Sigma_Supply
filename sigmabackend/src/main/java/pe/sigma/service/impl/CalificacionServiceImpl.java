package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.ICalificacionDao;
import pe.sigma.model.Calificacion;
import pe.sigma.service.ICalificacionService;

@Service
public class CalificacionServiceImpl implements ICalificacionService {

	@Autowired
	private ICalificacionDao dao;
	
	@Override
	public Calificacion registrar(Calificacion t) {
		return dao.save(t);
	}

	@Override
	public Calificacion modificar(Calificacion t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Calificacion> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Calificacion> listar() {
		return dao.findAll();
	}

}
