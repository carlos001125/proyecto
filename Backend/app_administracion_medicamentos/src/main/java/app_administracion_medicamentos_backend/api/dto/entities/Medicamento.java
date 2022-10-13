package app_administracion_medicamentos_backend.api.dto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medicamento")
	private Long id_medicamento;
	
	@Column(name = "nombre_medicamento", unique = false, nullable = false)
	private String nombre_medicamento;
	
	@Column(name = "contenido_medicamento", unique = false, nullable = false)
	private String contenido_medicamento;
	
	
	@ManyToMany(mappedBy = "medicamentos")
	@JsonIgnore
	private List<Cliente> clientes = new ArrayList<>();


}
