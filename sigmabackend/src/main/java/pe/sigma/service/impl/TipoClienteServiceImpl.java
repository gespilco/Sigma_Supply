package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.ITipoClienteDao;
import pe.sigma.model.TipoCliente;
import pe.sigma.service.ITipoClienteService;

@Service
public class TipoClienteServiceImpl implements ITipoClienteService {

	@Autowired
	private ITipoClienteDao dao;

	@Override
	public TipoCliente registrar(TipoCliente t) {
		return dao.save(t);
	}

	@Override
	public TipoCliente modificar(TipoCliente t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<TipoCliente> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<TipoCliente> listar() {
		return dao.findAll();
	}

}
