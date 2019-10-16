package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.Programacion;

public interface IProgramacionDao extends JpaRepository<Programacion, Integer> {

}
