package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.sigma.model.TipoSolicitud;

@Repository
public interface ITipoSolicitudDao extends JpaRepository<TipoSolicitud, Integer>{

}
