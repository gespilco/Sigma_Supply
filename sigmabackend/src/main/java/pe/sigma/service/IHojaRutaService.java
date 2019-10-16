package pe.sigma.service;

import java.util.List;

import pe.sigma.model.HojaRuta;

public interface IHojaRutaService extends ICRUD<HojaRuta>{

	List<String> verHojaRuta(Integer id_programa_visita);

	List<String> generarHojaRuta(Integer id_programa_visita);

	List<String> listarHojaRuta(Integer id_programa_visita);
}
