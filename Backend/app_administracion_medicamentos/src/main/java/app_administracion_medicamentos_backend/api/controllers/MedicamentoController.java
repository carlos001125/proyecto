package app_administracion_medicamentos_backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app_administracion_medicamentos_backend.api.dto.entities.Medicamento;
import app_administracion_medicamentos_backend.api.interfaces.controllers.IMedicamentoController;
import app_administracion_medicamentos_backend.api.publics.Response;
import app_administracion_medicamentos_backend.api.services.MedicamentoService;

@RestController
@RequestMapping(path = "/api/proyecto/medicamentos")
@CrossOrigin(value = "http://localhost:4200/")
public class MedicamentoController implements IMedicamentoController<Medicamento> {
	
	@Autowired
	MedicamentoService medicamentoService;

	// http://localhost:8084/api/proyecto/medicamentos/getAll
	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Medicamento>>> getAll() {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), medicamentoService.getAll(), "Datos obtenidos"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Medicamento>> getById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), medicamentoService.getById(id), "Datos obtenidos"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Medicamento>> createOrUpdate(@RequestBody Medicamento entity) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), medicamentoService.createOrUpdate(entity), "Datos registrados"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Medicamento>> deleteById(@PathVariable Long id) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), medicamentoService.deleteById(id), "Datos eliminados"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getByClienteId/{id_cliente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Medicamento>>> getAllByClienteId(@PathVariable Long id_cliente) {
		return ResponseEntity
				.ok(new Response<>(String.valueOf(HttpStatus.OK), medicamentoService.getAllByClienteId(id_cliente), "Datos obtenidos"));
	}

}
