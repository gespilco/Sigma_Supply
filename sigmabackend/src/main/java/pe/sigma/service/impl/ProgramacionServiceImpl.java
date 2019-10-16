package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IProgramacionDao;
import pe.sigma.model.Programacion;
import pe.sigma.service.IProgramacionService;

@Service
public class ProgramacionServiceImpl implements IProgramacionService {

	@Autowired
	private IProgramacionDao dao;
	
	@Override
	public Programacion registrar(Programacion t) {
		return dao.save(t);
	}

	@Override
	public Programacion modificar(Programacion t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Programacion> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Programacion> listar() {
		return dao.findAll();
	}

}
