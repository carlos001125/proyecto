package app_administracion_medicamentos_backend.api.interfaces.services;

import java.util.List;

public interface ICliente_MedicamentoService<T> {


	public List<T> getAll();

	public T getById(Long id);

	public T createOrUpdate(T entity);

	public T deleteById(Long id);

	
}
