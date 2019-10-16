package pe.sigma.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.sigma.model.OrdenServicio;

public interface IOrdenServicioDao extends JpaRepository<OrdenServicio, Integer> {
	@Modifying
	@Query(value = "SELECT sistema.fn_busqueda_orden_servicio(:id_orden_servicio,:fecha_recepcion,:id_tipo_solicitud,:id_estado)", nativeQuery = true)
	List<String> listarOrdenServicio(@Param("id_orden_servicio") Integer id_orden_servicio,@Param("fecha_recepcion") String fecha_recepcion,@Param("id_tipo_solicitud") Integer id_tipo_prioridad,@Param("id_estado") Integer id_estado);

	@Modifying
	@Query(value = "SELECT sistema.fn_listar_orden_servicio(:id_orden_servicio,:fecha_recepcion,:id_tipo_solicitud,:id_estado,:skip,:take)", nativeQuery = true)
	List<String> listarOrdenServicioPag(Integer id_orden_servicio, String fecha_recepcion, Integer id_tipo_solicitud,Integer id_estado, Integer skip, Integer take);

//	@Modifying
//	@Query(value = "SELECT sistema.fn_busqueda_orden_servicio_pag(:id_orden_servicio,:fecha_recepcion,:id_tipo_solicitud,:id_estado,:skip,:take)", nativeQuery = true)
//	List<String> listarOrdenServicioPag(Integer id_orden_servicio, String fecha_recepcion, Integer id_tipo_solicitud,Integer id_estado, Integer skip, Integer take);

	
	@Modifying
	@Query(value = "SELECT sistema.fn_busqueda_orden_servicio_pag_num(:numero_orden,:fecha_recepcion,:id_tipo_solicitud,:id_estado,:skip,:take)", nativeQuery = true)
	List<String> listarOrdenServicioPagNum(String numero_orden, String fecha_recepcion, Integer id_tipo_solicitud,Integer id_estado, Integer skip, Integer take);
}
	