package app_administracion_medicamentos_backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app_administracion_medicamentos_backend.api.dto.entities.Cliente;
import app_administracion_medicamentos_backend.api.interfaces.controllers.IClienteController;
import app_administracion_medicamentos_backend.api.publics.Response;
import app_administracion_medicamentos_backend.api.services.ClienteService;

@RestController
@RequestMapping(path = "/api/proyecto/clientes")
@CrossOrigin(value = "http://localhost:4200/")
public class ClienteController implements IClienteController<Cliente>{
	
	@Autowired
	ClienteService clienteService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Cliente>>> getAll() {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), clienteService.getAll(), "Datos obtenidos"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente>> getById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), clienteService.getById(id), "Datos obtenidos"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente>> createOrUpdate(@RequestBody Cliente entity) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), clienteService.createOrUpdate(entity), "Datos registrados"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente>> deleteById(Long id) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), clienteService.deleteById(id), "Datos eliminados"));
	}
	
	

}
