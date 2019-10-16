package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.TipoPrioridad;

public interface ITipoPrioridadDao extends JpaRepository<TipoPrioridad, Integer> {

}
