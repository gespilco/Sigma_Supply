package pe.sigma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.sigma.model.HojaRuta;

public interface IHojaRutaDao extends JpaRepository<HojaRuta, Integer>{
	@Modifying
	@Query(value = "SELECT sistema.fn_ver_hoja_ruta(:id_programa_visita)", nativeQuery = true)
	List<String> verHojaRuta(Integer id_programa_visita);
	
	@Modifying
	@Query(value = "SELECT sistema.fn_generar_hoja_ruta(:id_programa_visita)", nativeQuery = true)
	List<String> generarHojaRuta(Integer id_programa_visita);
	
	@Modifying
	@Query(value = "SELECT sistema.fn_listar_hoja_ruta(:id_programa_visita)", nativeQuery = true)
	List<String> listarHojaRuta(Integer id_programa_visita);
}
