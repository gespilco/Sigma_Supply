package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.ISolicitudDao;
import pe.sigma.model.Solicitud;
import pe.sigma.service.ISolicitudService;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

	@Autowired
	private ISolicitudDao dao;
	
	@Override
	public Solicitud registrar(Solicitud t) {
		return dao.save(t);
	}

	@Override
	public Solicitud modificar(Solicitud t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Solicitud> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Solicitud> listar() {
		return dao.findAll();
	}

}
