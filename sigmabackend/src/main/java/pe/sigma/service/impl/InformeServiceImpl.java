package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IInformeDao;
import pe.sigma.model.Informe;
import pe.sigma.service.IInformeService;

@Service
public class InformeServiceImpl implements IInformeService {

	@Autowired
	private IInformeDao dao;
	
	@Override
	public Informe registrar(Informe t) {
		return dao.save(t);
	}

	@Override
	public Informe modificar(Informe t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Informe> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Informe> listar() {
		return dao.findAll();
	}

}
