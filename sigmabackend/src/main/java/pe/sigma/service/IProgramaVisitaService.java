package pe.sigma.service;

import java.util.List;

import pe.sigma.model.ProgramaVisita;

public interface IProgramaVisitaService extends ICRUD<ProgramaVisita>  {

	List<String> listarProgramaVisitaPag(Integer id_tecnico, String fecha,Integer skip, Integer take);

}
