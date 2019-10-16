package pe.sigma.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sigma.dao.IOrdenServicioDao;
import pe.sigma.model.OrdenServicio;
import pe.sigma.service.IOrdenServicioService;

@Service
public class OrdenServicioServiceImpl implements IOrdenServicioService {

	@Autowired
	private IOrdenServicioDao dao;
	
	@Override
	public OrdenServicio registrar(OrdenServicio t) {
		return dao.save(t);
	}

	@Override
	public OrdenServicio modificar(OrdenServicio t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<OrdenServicio> listarId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<OrdenServicio> listar() {
		return dao.findAll();
	}
	
	@Override
	public List<String> listarOrdenServicio(Integer id_orden_servicio,String fecha_recepcion,Integer id_tipo_solicitud,Integer id_estado) {
		return dao.listarOrdenServicio(id_orden_servicio, fecha_recepcion, id_tipo_solicitud, id_estado);
	}
	
	@Override
	public List<String> listarOrdenServicioPag(Integer id_orden_servicio,String fecha_recepcion,Integer id_tipo_solicitud,Integer id_estado,Integer skip,Integer take) {
		return dao.listarOrdenServicioPag(id_orden_servicio, fecha_recepcion, id_tipo_solicitud, id_estado,skip,take);
	}

	@Override
	public List<String> listarOrdenServicioPagNum(String numero_orden, String fecha_recepcion,Integer id_tipo_solicitud, Integer id_estado, Integer skip, Integer take) {
		return dao.listarOrdenServicioPagNum(numero_orden, fecha_recepcion, id_tipo_solicitud, id_estado,skip,take);
	}

}
