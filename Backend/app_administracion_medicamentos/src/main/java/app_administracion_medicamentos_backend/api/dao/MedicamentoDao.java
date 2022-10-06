package app_administracion_medicamentos_backend.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import app_administracion_medicamentos_backend.api.dto.entities.Medicamento;

@Repository
public interface MedicamentoDao extends JpaRepository<Medicamento, Long>{
	
	@Query("SELECT m FROM Medicamento m WHERE m.id_medicamento = :id")
	public Medicamento getById(@PathVariable Long id);
	
	@Query(value = "select c.nombre_cliente from Cliente c inner join cliente_medicamento mc on c.id_cliente = mc.id_cliente", nativeQuery = true)
	public List<Medicamento> getAllByClienteId(@PathVariable Long id_cliente);
}
