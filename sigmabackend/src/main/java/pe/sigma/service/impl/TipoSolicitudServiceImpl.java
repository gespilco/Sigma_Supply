package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.ITipoSolicitudDao;
import pe.sigma.model.TipoSolicitud;
import pe.sigma.service.ITipoSolicitudService;

@Service
public class TipoSolicitudServiceImpl implements ITipoSolicitudService{

	@Autowired
	private ITipoSolicitudDao dao;
	
	@Override
	public TipoSolicitud registrar(TipoSolicitud t) {
		return dao.save(t);
	}

	@Override
	public TipoSolicitud modificar(TipoSolicitud t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<TipoSolicitud> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<TipoSolicitud> listar() {
		return dao.findAll();
	}

}
