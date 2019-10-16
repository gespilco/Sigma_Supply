package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Integer>{

}
