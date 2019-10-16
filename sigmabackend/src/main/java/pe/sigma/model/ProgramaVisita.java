package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "programa_visita")
public class ProgramaVisita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_programa_visita;

	@Column(name = "programacion", nullable = true, length = 200)
	private String programa_visita;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_programada;

	@Column(name = "acepta_tecnico", nullable = true)
	private boolean acepta_tecnico;

	@Column(name = "acepta_cliente", nullable = true)
	private boolean acepta_cliente;
	
	@Column(name = "codigo_visita", nullable = true, length = 500)
	private String codigo_visita;	

	@Column(name = "descripcion", nullable = true, length = 500)
	private String descripcion;

	@Column(name = "observacion", nullable = true, length = 500)
	private String observacion;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_visita;	

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

	public Integer getId_programa_visita() {
		return id_programa_visita;
	}

	public void setId_programa_visita(Integer id_programa_visita) {
		this.id_programa_visita = id_programa_visita;
	}

	public String getPrograma_visita() {
		return programa_visita;
	}

	public void setPrograma_visita(String programa_visita) {
		this.programa_visita = programa_visita;
	}

	public LocalDateTime getFecha_programada() {
		return fecha_programada;
	}

	public void setFecha_programada(LocalDateTime fecha_programada) {
		this.fecha_programada = fecha_programada;
	}

	public boolean isAcepta_tecnico() {
		return acepta_tecnico;
	}

	public void setAcepta_tecnico(boolean acepta_tecnico) {
		this.acepta_tecnico = acepta_tecnico;
	}

	public boolean isAcepta_cliente() {
		return acepta_cliente;
	}

	public void setAcepta_cliente(boolean acepta_cliente) {
		this.acepta_cliente = acepta_cliente;
	}

	public String getCodigo_visita() {
		return codigo_visita;
	}

	public void setCodigo_visita(String codigo_visita) {
		this.codigo_visita = codigo_visita;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public LocalDateTime getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(LocalDateTime fecha_visita) {
		this.fecha_visita = fecha_visita;
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
