package app_administracion_medicamentos_backend.api.dao;

import java.util.List;

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
	
	
	@Query(value = "select cm.id_cliente_medicamento, cm.completado_medicamento, cm.fecha_medicacion, cm.hora_medicacion, m.nombre_medicamento, cm.id_cliente FROM cliente_medicamento cm INNER JOIN medicamento m ON m.id_medicamento = cm.id_medicamento where cm.id_cliente = :id", nativeQuery = true)
	public List<Cliente_Medicamento> getAllByClientId(@PathVariable Long id);
	
}
