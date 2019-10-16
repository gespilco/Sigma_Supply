package pe.sigma.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "capacitacion_tecnico")
public class CapacitacionTecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_capacitacion_tecnico;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnico", nullable = true)
	private Tecnico tecnico;
	
	@Column(name = "curso_capacitacion", nullable = true, length = 300)
	private String curso_capacitacion;
	
	@Column(name = "horas_capacitacion", nullable = true, length = 300)
	private String horas_capacitacion;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_capacitacion;
	
	@Column(name = "activo", nullable = true)
	private boolean activo;
	
	@Column(name = "usuario_creacion", nullable = true)
	private Integer usuario_creacion;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_creacion;
	
	@Column(name = "usuario_modificacion", nullable = true)
	private Integer usuario_modificacion;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_modificacion;
	
	@Column(name = "usuario_eliminacion", nullable = true)
	private Integer usuario_eliminacion;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_eliminacion;

	public Integer getId_capacitacion_tecnico() {
		return id_capacitacion_tecnico;
	}

	public void setId_capacitacion_tecnico(Integer id_capacitacion_tecnico) {
		this.id_capacitacion_tecnico = id_capacitacion_tecnico;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getCurso_capacitacion() {
		return curso_capacitacion;
	}

	public void setCurso_capacitacion(String curso_capacitacion) {
		this.curso_capacitacion = curso_capacitacion;
	}

	public String getHoras_capacitacion() {
		return horas_capacitacion;
	}

	public void setHoras_capacitacion(String horas_capacitacion) {
		this.horas_capacitacion = horas_capacitacion;
	}

	public LocalDateTime getFecha_capacitacion() {
		return fecha_capacitacion;
	}

	public void setFecha_capacitacion(LocalDateTime fecha_capacitacion) {
		this.fecha_capacitacion = fecha_capacitacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Integer getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(Integer usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Integer getUsuario_modificacion() {
		return usuario_modificacion;
	}

	public void setUsuario_modificacion(Integer usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}

	public LocalDateTime getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(LocalDateTime fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public Integer getUsuario_eliminacion() {
		return usuario_eliminacion;
	}

	public void setUsuario_eliminacion(Integer usuario_eliminacion) {
		this.usuario_eliminacion = usuario_eliminacion;
	}

	public LocalDateTime getFecha_eliminacion() {
		return fecha_eliminacion;
	}

	public void setFecha_eliminacion(LocalDateTime fecha_eliminacion) {
		this.fecha_eliminacion = fecha_eliminacion;
	}
	
	

}
