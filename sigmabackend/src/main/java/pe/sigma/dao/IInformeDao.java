package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.Informe;

public interface IInformeDao extends JpaRepository<Informe, Integer> {

}
