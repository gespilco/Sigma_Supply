package pe.sigma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.sigma.model.ParametroSistema;

public interface IParametroSistemaDao extends JpaRepository<ParametroSistema, Integer> {

	
	@Modifying
	@Query(value = "SELECT sistema.fn_parametros_sistema_tecnico(:id_solicitud)", nativeQuery = true)
	List<String> listarParametroSistemaTec(Integer id_solicitud);

}
