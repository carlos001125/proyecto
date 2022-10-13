package app_administracion_medicamentos_backend.api.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app_administracion_medicamentos_backend.api.dto.entities.Cliente_Medicamento;
import app_administracion_medicamentos_backend.api.interfaces.controllers.ICliente_MedicamentoController;
import app_administracion_medicamentos_backend.api.publics.Response;
import app_administracion_medicamentos_backend.api.services.Cliente_MedicamentoService;

@RestController
@RequestMapping(path = "/api/proyecto/clientes_medicamentos")
@CrossOrigin(value = "http://localhost:4200/")
public class Cliente_MedicamentoController implements ICliente_MedicamentoController<Cliente_Medicamento> {

	@Autowired
	Cliente_MedicamentoService cliente_MedicamentoService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Cliente_Medicamento>>> getAll() {
		return ResponseEntity.ok(
				new Response<>(String.valueOf(HttpStatus.OK), cliente_MedicamentoService.getAll(), "Datos obtenidos"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente_Medicamento>> getById(@PathVariable Long id) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), cliente_MedicamentoService.getById(id),
				"Datos obtenidos"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/createOrUpdate", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente_Medicamento>> createOrUpdate(@RequestBody Cliente_Medicamento entity) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK),
				cliente_MedicamentoService.createOrUpdate(entity), "Datos registrados"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Cliente_Medicamento>> deleteById(@PathVariable Long id) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK),
				cliente_MedicamentoService.deleteById(id), "Datos eliminados"));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getAllByClientId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Cliente_Medicamento>>> getAllByClientId(@PathVariable Long id) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK),
				this.cliente_MedicamentoService.getAllByClientId(id), "Datos obtenidos correctamente"));
	}

}
