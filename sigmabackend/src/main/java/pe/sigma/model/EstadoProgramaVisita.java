package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "estado_programa_visita")
public class EstadoProgramaVisita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estado_programa_visita;

	@ManyToOne
	@JoinColumn(name = "id_programa_visita", nullable = true)
	private ProgramaVisita programaVisita;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = true)
	private Estado estado;

	@Column(name = "estado_programa_visita", nullable = true, length = 300)
	private String estado_programa_visita;

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

	public Integer getId_estado_programa_visita() {
		return id_estado_programa_visita;
	}

	public void setId_estado_programa_visita(Integer id_estado_programa_visita) {
		this.id_estado_programa_visita = id_estado_programa_visita;
	}

	public ProgramaVisita getProgramaVisita() {
		return programaVisita;
	}

	public void setProgramaVisita(ProgramaVisita programaVisita) {
		this.programaVisita = programaVisita;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getEstado_programa_visita() {
		return estado_programa_visita;
	}

	public void setEstado_programa_visita(String estado_programa_visita) {
		this.estado_programa_visita = estado_programa_visita;
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
