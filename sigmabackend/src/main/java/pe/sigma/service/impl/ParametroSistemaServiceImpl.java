package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IParametroSistemaDao;
import pe.sigma.model.ParametroSistema;
import pe.sigma.service.IParametroSistemaService;

@Service
public class ParametroSistemaServiceImpl implements IParametroSistemaService{
	@Autowired
	private IParametroSistemaDao dao;

	@Override
	public ParametroSistema registrar(ParametroSistema t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public ParametroSistema modificar(ParametroSistema t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public Optional<ParametroSistema> listarId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<ParametroSistema> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public List<String> listarParametroSistemaTec(Integer id_solicitud) {
		return dao.listarParametroSistemaTec(id_solicitud);
	}
}
