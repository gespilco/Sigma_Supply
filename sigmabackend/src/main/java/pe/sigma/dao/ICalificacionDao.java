package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.Calificacion;

public interface ICalificacionDao extends JpaRepository<Calificacion, Integer> {

}
