package app_administracion_medicamentos_backend.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import app_administracion_medicamentos_backend.api.dto.entities.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long>{
	
	@Query(value = "SELECT c.* FROM Cliente c WHERE c.id_cliente = :id", nativeQuery = true)
	public Cliente getById(@PathVariable Long id);

}
