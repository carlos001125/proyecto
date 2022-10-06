package app_administracion_medicamentos_backend.api.dto.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import app_administracion_medicamentos_backend.api.dto.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "nombre_usuario", unique = true, nullable = false)
	private String nombre_usuario;
	
	@Column(name = "correo_usuario", unique = true, nullable = false)
	private String correo_usuario;
	
	@Column(name = "clave_usuario", unique = false, nullable = false)
	private String clave_usuario;
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
  
}









