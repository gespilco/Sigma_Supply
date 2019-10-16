package pe.sigma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sigma.model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer>{

}
