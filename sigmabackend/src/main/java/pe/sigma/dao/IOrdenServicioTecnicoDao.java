package pe.sigma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.sigma.model.OrdenServicioTecnico;

public interface IOrdenServicioTecnicoDao extends JpaRepository<OrdenServicioTecnico, Integer>{


	
	@Modifying
	@Query(value = "SELECT sistema.fn_busqueda_tecnico_orden_servicio(:id_orden_servicio)", nativeQuery = true)
	List<String> listarOrdenServicioTec(Integer id_orden_servicio);

	@Modifying
	@Query(value = "SELECT sistema.fn_obtener_tecnico_orden_servicio(:id_orden_servicio,:id_tecnico)", nativeQuery = true)
	List<String> objOrdenServicioTec(Integer id_orden_servicio, Integer id_tecnico);

}
