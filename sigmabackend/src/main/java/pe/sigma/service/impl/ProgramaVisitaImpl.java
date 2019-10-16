package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IProgramaVisitaDao;
import pe.sigma.model.ProgramaVisita;
import pe.sigma.service.IProgramaVisitaService;

@Service
public class ProgramaVisitaImpl implements IProgramaVisitaService {
	
	@Autowired
	private IProgramaVisitaDao dao;
	
	@Override
	public ProgramaVisita registrar(ProgramaVisita t) {
		return dao.save(t);
	}

	@Override
	public ProgramaVisita modificar(ProgramaVisita t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<ProgramaVisita> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<ProgramaVisita> listar() {
		return dao.findAll();
	}

	@Override
	public List<String> listarProgramaVisitaPag(Integer id_tecnico,String fecha,Integer skip,Integer take) {
		return dao.listarProgramaVisitaPag(id_tecnico, fecha, skip,take);
	}
}
