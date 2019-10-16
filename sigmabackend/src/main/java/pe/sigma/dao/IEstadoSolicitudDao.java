package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.EstadoSolicitud;

public interface IEstadoSolicitudDao extends JpaRepository<EstadoSolicitud, Integer> {

}
