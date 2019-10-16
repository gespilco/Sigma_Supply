package pe.sigma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.sigma.model.ProgramaVisita;


public interface IProgramaVisitaDao extends JpaRepository<ProgramaVisita, Integer>{

	@Modifying
	@Query(value = "SELECT sistema.fn_listar_programa_visita(:id_tecnico,:fecha,:skip,:take)", nativeQuery = true)
	List<String> listarProgramaVisitaPag(Integer id_tecnico, String fecha, Integer skip, Integer take);

	
}
