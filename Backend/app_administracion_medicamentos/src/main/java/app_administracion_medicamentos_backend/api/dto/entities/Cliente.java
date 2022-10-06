package app_administracion_medicamentos_backend.api.dto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id_cliente;
	
	@Column(name = "nombre_cliente", unique = false, nullable = false)
	private String nombre_cliente;
	
	
	@Column(name = "apellido_paterno_cliente", unique = false, nullable = false)
	private String apellido_paterno_cliente;
	
	@Column(name = "apellido_materno_cliente", unique = false, nullable = false)
	private String apellido_materno_cliente;
	
	@Column(name = "edad_cliente", unique = false, nullable = false)
	private Integer edad_cliente;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "cliente_medicamento", joinColumns = @JoinColumn(
			name = "id_cliente"), inverseJoinColumns = @JoinColumn(name = "id_medicamento"))
	private List<Medicamento> medicamentos = new ArrayList<>();
	
	

}
