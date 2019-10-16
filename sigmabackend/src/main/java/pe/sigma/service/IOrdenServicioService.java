package pe.sigma.service;


import java.util.List;

import pe.sigma.model.OrdenServicio;

public interface IOrdenServicioService extends ICRUD<OrdenServicio> {
	List<String> listarOrdenServicio(Integer id_orden_servicio,String fecha_recepcion,Integer id_tipo_solicitud, Integer id_estado);

	List<String> listarOrdenServicioPag(Integer id_orden_servicio, String fecha_recepcion, Integer id_tipo_solicitud,Integer id_estado, Integer skip, Integer take);

	List<String> listarOrdenServicioPagNum(String numero_orden, String fecha_recepcion, Integer id_tipo_solicitud,Integer id_estado, Integer skip, Integer take);
}
