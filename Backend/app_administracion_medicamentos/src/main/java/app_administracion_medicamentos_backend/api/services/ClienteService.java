package app_administracion_medicamentos_backend.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app_administracion_medicamentos_backend.api.dao.ClienteDao;
import app_administracion_medicamentos_backend.api.dto.entities.Cliente;
import app_administracion_medicamentos_backend.api.interfaces.services.IClienteService;

@Service
public class ClienteService implements IClienteService<Cliente>{
	
	@Autowired
	ClienteDao clienteDao;

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = this.clienteDao.findAll();
		return clientes;
	}

	@Override
	public Cliente getById(Long id) {
		return this.clienteDao.getById(id);
	}

	@Override
	public Cliente createOrUpdate(Cliente entity) {
		try {
			Cliente cliente = this.clienteDao.save(entity);
			return cliente;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Cliente deleteById(Long id) {
		Cliente cliente = getById(id);
		if(cliente != null) {
			this.clienteDao.deleteById(id);
			return cliente;
		}
		return null;
	}

}
