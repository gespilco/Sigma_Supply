package pe.sigma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.sigma.model.Tecnico;

@Repository
public interface ITecnicoDao extends JpaRepository<Tecnico, Integer>{

	
	@Modifying
	@Query(value = "SELECT sistema.fn_busqueda_heuristica(:id_solicitud)", nativeQuery = true)
	List<String> listarTecnicosHeuristica(@Param("id_solicitud") Integer id_solicitud);

}
