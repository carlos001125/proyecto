package app_administracion_medicamentos_backend.api.interfaces.services;

import java.util.List;



public interface IMedicamentoService<T> {

	public List<T> getAll();
	
	public T getById(Long id);
	
	public T createOrUpdate(T entity);
	
	public T deleteById(Long id);
	
	public List<T> getAllByClienteId(Long id_cliente);
	
}
