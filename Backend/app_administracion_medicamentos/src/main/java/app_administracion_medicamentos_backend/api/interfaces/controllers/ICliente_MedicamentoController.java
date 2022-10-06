package app_administracion_medicamentos_backend.api.interfaces.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import app_administracion_medicamentos_backend.api.publics.Response;

public interface ICliente_MedicamentoController<T> {

	public ResponseEntity<Response<List<T>>> getAll();

	public ResponseEntity<Response<T>> getById(Long id);

	public ResponseEntity<Response<T>> createOrUpdate(T entity);

	public ResponseEntity<Response<T>> deleteById(Long id);
	
}
