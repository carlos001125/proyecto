package app_administracion_medicamentos_backend.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import app_administracion_medicamentos_backend.api.dto.entities.Cliente;
import app_administracion_medicamentos_backend.api.dto.entities.Cliente_Medicamento;

@Repository
public interface Cliente_MedicamentoDao extends JpaRepository<Cliente_Medicamento, Long>{

	@Query(value = "SELECT cm.* FROM Cliente_Medicamento cm WHERE cm.id_cliente_medicamento = :id", nativeQuery = true)
	public Cliente_Medicamento getById(@PathVariable Long id);
	
}
