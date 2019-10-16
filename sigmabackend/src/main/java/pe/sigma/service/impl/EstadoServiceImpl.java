package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IEstadoDao;
import pe.sigma.model.Estado;
import pe.sigma.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService {

	@Autowired IEstadoDao dao;
	
	@Override
	public Estado registrar(Estado t) {
		return dao.save(t);
	}

	@Override
	public Estado modificar(Estado t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Estado> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Estado> listar() {
		return dao.findAll();
	}

}
