package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.ITecnicoDao;
import pe.sigma.model.Tecnico;
import pe.sigma.service.ITecnicoService;

@Service
public class TecnicoServiceImpl implements ITecnicoService {

	@Autowired
	private ITecnicoDao dao;

	@Override
	public Tecnico registrar(Tecnico t) {
		return dao.save(t);
	}

	@Override
	public Tecnico modificar(Tecnico t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Tecnico> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Tecnico> listar() {
		return dao.findAll();
	}


	@Override
	public List<String> listarTecnicoheristica(Integer id_solicitud) {
		return dao.listarTecnicosHeuristica(id_solicitud);
	}
}
