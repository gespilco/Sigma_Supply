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
@Table(name = "sub_tipo_solicitud")
public class SubTipoSolicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sub_tipo_solicitud;

	@ManyToOne
	@JoinColumn(name = "id_tipo_solicitud", nullable = true)
	private TipoSolicitud tipo_solicitud;
	
	@Column(name = "sub_tipo_solicitud", nullable = true, length = 70)
	private String sub_tipo_solicitud;

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

	public Integer getId_sub_tipo_solicitud() {
		return id_sub_tipo_solicitud;
	}

	public void setId_sub_tipo_solicitud(Integer id_sub_tipo_solicitud) {
		this.id_sub_tipo_solicitud = id_sub_tipo_solicitud;
	}

	public TipoSolicitud getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(TipoSolicitud tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

	public String getSub_tipo_solicitud() {
		return sub_tipo_solicitud;
	}

	public void setSub_tipo_solicitud(String sub_tipo_solicitud) {
		this.sub_tipo_solicitud = sub_tipo_solicitud;
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
