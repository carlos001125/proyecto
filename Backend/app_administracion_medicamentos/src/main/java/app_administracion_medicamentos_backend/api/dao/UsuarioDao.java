package app_administracion_medicamentos_backend.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import app_administracion_medicamentos_backend.api.dto.security.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	
	@Query(value = "select u.* from Usuario u where (u.nombre_usuario = :nombre and clave_usuario = :clave) or (u.correo_usuario = :correo and clave_usuario = :clave)", nativeQuery = true)
	public Usuario datosAcceso(@PathVariable String nombre, @PathVariable String correo, @PathVariable String clave);
	
	@Query(value = "select u.* from Usuario u where (u.nombre_usuario = :nombre or u.correo_usuario = :correo)", nativeQuery = true)
	public Usuario recuperarClave(@PathVariable String nombre, @PathVariable String correo);

}
