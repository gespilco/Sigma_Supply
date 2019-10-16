package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "encuesta_atencion_servicio")
public class EncuestaAtencionServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_encuesta_atencion_servicio;

	@OneToOne
	@JoinColumn(name = "visita", nullable = true)
	private Visita visita;

	@Column(name = "id_tecnico", nullable = true)
	private Integer id_tecnico;

	@Column(name = "descripcion", nullable = true, length = 300)
	private String descripcion;

	@Column(name = "recomendaciones", nullable = true, length = 300)
	private String recomendaciones;

	@Column(name = "conclusiones", nullable = true, length = 300)
	private String conclusiones;

	@Column(name = "observaciones", nullable = true, length = 300)
	private String observaciones;

	@Column(name = "calificacion_tecnico", nullable = true, length = 300)
	private String calificacion_tecnico;

	@Column(name = "calificacion_servicio", nullable = true, length = 300)
	private String calificacion_servicio;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_encuesta_servico;

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

	public Integer getId_encuesta_atencion_servicio() {
		return id_encuesta_atencion_servicio;
	}

	public void setId_encuesta_atencion_servicio(Integer id_encuesta_atencion_servicio) {
		this.id_encuesta_atencion_servicio = id_encuesta_atencion_servicio;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public Integer getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(Integer id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public String getConclusiones() {
		return conclusiones;
	}

	public void setConclusiones(String conclusiones) {
		this.conclusiones = conclusiones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCalificacion_tecnico() {
		return calificacion_tecnico;
	}

	public void setCalificacion_tecnico(String calificacion_tecnico) {
		this.calificacion_tecnico = calificacion_tecnico;
	}

	public String getCalificacion_servicio() {
		return calificacion_servicio;
	}

	public void setCalificacion_servicio(String calificacion_servicio) {
		this.calificacion_servicio = calificacion_servicio;
	}

	public LocalDateTime getFecha_encuesta_servico() {
		return fecha_encuesta_servico;
	}

	public void setFecha_encuesta_servico(LocalDateTime fecha_encuesta_servico) {
		this.fecha_encuesta_servico = fecha_encuesta_servico;
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
