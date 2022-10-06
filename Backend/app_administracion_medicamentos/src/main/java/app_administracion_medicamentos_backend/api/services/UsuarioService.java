package app_administracion_medicamentos_backend.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app_administracion_medicamentos_backend.api.dao.UsuarioDao;
import app_administracion_medicamentos_backend.api.dto.security.Usuario;
import app_administracion_medicamentos_backend.api.interfaces.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService<Usuario>{
	
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public List<Usuario> getAll() {
		return usuarioDao.findAll();
	}

	@Override
	public Usuario createOrUpdate(Usuario entity) {
		return this.usuarioDao.save(entity);
	}

	@Override
	public Usuario accesoExitoso(String usuario, String correo, String clave) {
		Usuario usuario_accedido = this.usuarioDao.datosAcceso(usuario, correo, clave);
		return usuario_accedido;
	}

	@Override
	public Usuario recuperarClave(String usuario, String correo) {
		Usuario usuario_a_recuperar = this.usuarioDao.recuperarClave(usuario, correo);
		return usuario_a_recuperar;
	}

}
