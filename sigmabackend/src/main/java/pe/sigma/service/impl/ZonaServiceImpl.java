package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IZonaDao;
import pe.sigma.model.Zona;
import pe.sigma.service.IZonaService;

@Service
public class ZonaServiceImpl implements IZonaService {

	@Autowired
	private IZonaDao dao;

	@Override
	public Zona registrar(Zona t) {
		return dao.save(t);
	}

	@Override
	public Zona modificar(Zona t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Zona> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Zona> listar() {
		return dao.findAll();
	}

}
