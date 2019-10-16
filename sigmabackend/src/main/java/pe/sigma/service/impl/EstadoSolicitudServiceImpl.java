package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IEstadoSolicitudDao;
import pe.sigma.model.EstadoSolicitud;
import pe.sigma.service.IEstadoSolicitudService;

@Service
public class EstadoSolicitudServiceImpl implements IEstadoSolicitudService{

	@Autowired
	private IEstadoSolicitudDao dao;
	
	@Override
	public EstadoSolicitud registrar(EstadoSolicitud t) {
		return dao.save(t);
	}

	@Override
	public EstadoSolicitud modificar(EstadoSolicitud t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<EstadoSolicitud> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<EstadoSolicitud> listar() {
		return dao.findAll();
	}

}
