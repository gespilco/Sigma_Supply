package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "tecnico")
@NamedNativeQueries({
		@NamedNativeQuery(name = "FN_LISTAR_EMPLEADOS_ALGORITMO", query = "SELECT * FROM FN_LISTAR_EMPLEADOS_ALGORITMO(:param1)", resultClass = Tecnico.class) })

public class Tecnico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tecnico;

	@Column(name = "nombre", nullable = true, length = 300)
	private String nombre;

	@Column(name = "codigo_tecnico", nullable = true, length = 300)
	private String codigo_tecnico;
	
	@Column(name = "apellido_paterno", nullable = true, length = 300)
	private String apellido_paterno;

	@Column(name = "apellido_materno", nullable = true, length = 300)
	private String apellido_materno;

	@Column(name = "profesion", nullable = true, length = 300)
	private String profesion;

	@Column(name = "especialidad", nullable = true, length = 300)
	private String especialidad;

	@Column(name = "es_supervisor", nullable = true)
	private boolean es_supervisor;

	@Column(name = "reten_contingencia", nullable = true)
	private boolean reten_contingencia;

	@Column(name = "observacion_reten", nullable = true, length = 300)
	private String observacion_reten;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_ingreso;

	@Column(name = "experiencia_anios_anteriores", nullable = true)
	private Integer experiencia_anios_anteriores;
	
	@Column(name = "archivo_foto", nullable = true)
	private String archivo_foto;

	@ManyToOne
	@JoinColumn(name = "id_zona", nullable = true)
	private Zona zona;

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

	public Integer getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(Integer id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public boolean isEs_supervisor() {
		return es_supervisor;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public void setEs_supervisor(boolean es_supervisor) {
		this.es_supervisor = es_supervisor;
	}

	public boolean isReten_contingencia() {
		return reten_contingencia;
	}

	public void setReten_contingencia(boolean reten_contingencia) {
		this.reten_contingencia = reten_contingencia;
	}

	public String getObservacion_reten() {
		return observacion_reten;
	}

	public void setObservacion_reten(String observacion_reten) {
		this.observacion_reten = observacion_reten;
	}

	public LocalDateTime getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDateTime fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Integer getExperiencia_anios_anteriores() {
		return experiencia_anios_anteriores;
	}

	public void setExperiencia_anios_anteriores(Integer experiencia_anios_anteriores) {
		this.experiencia_anios_anteriores = experiencia_anios_anteriores;
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

	public String getCodigo_tecnico() {
		return codigo_tecnico;
	}

	public void setCodigo_tecnico(String codigo_tecnico) {
		this.codigo_tecnico = codigo_tecnico;
	}
	
	

}
