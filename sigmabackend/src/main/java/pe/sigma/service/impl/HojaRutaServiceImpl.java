package pe.sigma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IHojaRutaDao;
import pe.sigma.model.HojaRuta;
import pe.sigma.service.IHojaRutaService;

@Service
public class HojaRutaServiceImpl implements IHojaRutaService {

	@Autowired
	private IHojaRutaDao dao;
	
	@Override
	public HojaRuta registrar(HojaRuta t) {
		return dao.save(t);
	}

	@Override
	public HojaRuta modificar(HojaRuta t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<HojaRuta> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<HojaRuta> listar() {
		return dao.findAll();
	}
	
	@Override
	public List<String> verHojaRuta(Integer id_programa_visita) {
		return dao.verHojaRuta(id_programa_visita);
	}
	
	@Override
	public List<String> generarHojaRuta(Integer id_programa_visita) {
		return dao.generarHojaRuta(id_programa_visita);
	}

	@Override
	public List<String> listarHojaRuta(Integer id_programa_visita) {
		return dao.listarHojaRuta(id_programa_visita);
	}
}
