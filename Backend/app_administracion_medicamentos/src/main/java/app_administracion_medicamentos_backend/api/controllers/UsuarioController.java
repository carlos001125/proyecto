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

import app_administracion_medicamentos_backend.api.dto.security.Usuario;
import app_administracion_medicamentos_backend.api.interfaces.controllers.IUsuarioController;
import app_administracion_medicamentos_backend.api.publics.Response;
import app_administracion_medicamentos_backend.api.services.UsuarioService;

@RestController
@RequestMapping(path = "/api/proyecto/usuarios")
@CrossOrigin(value = "http://localhost:4200/")
public class UsuarioController implements IUsuarioController<Usuario> {

	@Autowired
	UsuarioService usuarioService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Usuario>>> getAll() {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK), this.usuarioService.getAll(),
				"Datos obtenidos exitosamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Usuario>> createOrUpdate(@RequestBody Usuario entity) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK),
				this.usuarioService.createOrUpdate(entity), "Datos obtenidos exitosamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getUserAccess/{usuario}/{correo}/{clave}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Usuario>> accesoExitoso(@PathVariable String usuario, @PathVariable String correo, @PathVariable String clave) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK),
				this.usuarioService.accesoExitoso(usuario, correo, clave), "Datos obtenidos exitosamente"));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/getUserRescue/{usuario}/{correo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Usuario>> recuperarContraseña(@PathVariable String usuario, @PathVariable String correo) {
		return ResponseEntity.ok(new Response<>(String.valueOf(HttpStatus.OK),
				this.usuarioService.recuperarClave(usuario, correo), "Datos obtenidos exitosamente"));
	}

}
