package app_administracion_medicamentos_backend.api.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app_administracion_medicamentos_backend.api.dao.Cliente_MedicamentoDao;
import app_administracion_medicamentos_backend.api.dto.entities.Cliente_Medicamento;
import app_administracion_medicamentos_backend.api.interfaces.services.ICliente_MedicamentoService;

@Service
public class Cliente_MedicamentoService implements ICliente_MedicamentoService<Cliente_Medicamento> {

	@Autowired
	Cliente_MedicamentoDao cliente_MedicamentoDao;

	@Override
	public List<Cliente_Medicamento> getAll() {
		List<Cliente_Medicamento> cliente_medicamento_lista = this.cliente_MedicamentoDao.findAll();
		return cliente_medicamento_lista;
	}

	@Override
	public Cliente_Medicamento getById(Long id) {
		return this.cliente_MedicamentoDao.getById(id);
	}

	@Override
	public Cliente_Medicamento createOrUpdate(Cliente_Medicamento entity) {
		return this.cliente_MedicamentoDao.save(entity);
	}

	@Override
	public Cliente_Medicamento deleteById(Long id) {
		Cliente_Medicamento cliente_Medicamento = getById(id);
		if (cliente_Medicamento != null) {
			this.cliente_MedicamentoDao.deleteById(id);
			return cliente_Medicamento;
		}
		return null;
	}
	
	  public List<Cliente_Medicamento> getAllByClientId(Long id){
	  List<Cliente_Medicamento> resultadosPorId =
	  this.cliente_MedicamentoDao.getAllByClientId(id); return resultadosPorId; }
	 

	

}
