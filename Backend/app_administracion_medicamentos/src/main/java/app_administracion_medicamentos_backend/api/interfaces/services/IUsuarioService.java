package app_administracion_medicamentos_backend.api.interfaces.services;

import java.util.List;

public interface IUsuarioService<T> {

	
	public List<T> getAll();

	public T createOrUpdate(T entity);

	public T accesoExitoso(String usuario, String correo, String clave);
	
	public T recuperarClave(String usuario, String correo);
	
}
