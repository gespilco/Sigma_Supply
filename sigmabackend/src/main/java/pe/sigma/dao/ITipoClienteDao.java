package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.TipoCliente;

public interface ITipoClienteDao extends JpaRepository<TipoCliente, Integer>{

}
