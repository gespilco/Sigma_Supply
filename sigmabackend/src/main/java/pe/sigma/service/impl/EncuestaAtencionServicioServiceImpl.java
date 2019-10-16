package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IEncuestaAtencionServicioDao;
import pe.sigma.model.EncuestaAtencionServicio;
import pe.sigma.service.IEncuestaAtencionServicioService;

@Service
public class EncuestaAtencionServicioServiceImpl implements IEncuestaAtencionServicioService {

	@Autowired
	private IEncuestaAtencionServicioDao dao;
	
	@Override
	public EncuestaAtencionServicio registrar(EncuestaAtencionServicio t) {
		return dao.save(t);
	}

	@Override
	public EncuestaAtencionServicio modificar(EncuestaAtencionServicio t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<EncuestaAtencionServicio> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<EncuestaAtencionServicio> listar() {
		return dao.findAll();
	}

}
