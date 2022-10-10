package app_administracion_medicamentos_backend.api.dto.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_medicamento")
public class Cliente_Medicamento implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente_medicamento")
	private Long id_cliente_medicamento;
	
	@Column(name = "id_cliente")
	private Long id_cliente;
	
	@Column(name = "id_medicamento")
	private Long id_medicamento;
	
	@Column(name = "completado_medicamento")
	private Boolean completado_medicamento;
	
	@Column(name = "hora_medicacion")
	private String hora_medicacion;
	
	@Column(name = "fecha_medicacion")
	private String fecha_medicacion;
	
	
}









