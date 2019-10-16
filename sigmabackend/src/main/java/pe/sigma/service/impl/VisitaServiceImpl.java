package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IVisitaDao;
import pe.sigma.model.Visita;
import pe.sigma.service.IVisitaService;

@Service
public class VisitaServiceImpl implements IVisitaService {

	@Autowired
	private IVisitaDao dao;
	
	@Override
	public Visita registrar(Visita t) {
		return dao.save(t);
	}

	@Override
	public Visita modificar(Visita t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Visita> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Visita> listar() {
		return dao.findAll();
	}

}
