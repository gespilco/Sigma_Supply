package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "parametros_mapa")
public class ParametrosMapa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_parametro_mapa;

	@Column(name = "id_tipo_solicitud", nullable = true)
	 private Integer id_tipo_solicitud;
	
	@Column(name = "id_tipo_prioridad", nullable = true)
	 private Integer id_tipo_prioridad;
	
	@Column(name = "id_sub_tipo_solicitud", nullable = true)
	 private Integer id_sub_tipo_solicitud;
	
	@Column(name = "id_complejidad_servicio", nullable = true)
	 private Integer id_complejidad_servicio;

	@Column(name = "tabla", nullable = true, length = 300)
	private String tabla;

	@Column(name = "subtabla", nullable = true, length = 300)
	private String subtabla;

	@Column(name = "descripcion", nullable = true, length = 300)
	private String descripcion;

	@Column(name = "valores", nullable = true, length = 300)
	private String valores;
	
	@Column(name = "cantidad", nullable = true, length = 300)
	private String cantidad;
	
	@Column(name = "especilidad", nullable = true, length = 300)
	private String especialidad;

	@Column(name = "id_padre", nullable = true)
	private Integer id_padre;

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

	public Integer getId_parametro_mapa() {
		return id_parametro_mapa;
	}

	public void setId_parametro_mapa(Integer id_parametro_mapa) {
		this.id_parametro_mapa = id_parametro_mapa;
	}

	public Integer getId_tipo_solicitud() {
		return id_tipo_solicitud;
	}

	public void setId_tipo_solicitud(Integer id_tipo_solicitud) {
		this.id_tipo_solicitud = id_tipo_solicitud;
	}

	public Integer getId_tipo_prioridad() {
		return id_tipo_prioridad;
	}

	public void setId_tipo_prioridad(Integer id_tipo_prioridad) {
		this.id_tipo_prioridad = id_tipo_prioridad;
	}

	public Integer getId_sub_tipo_solicitud() {
		return id_sub_tipo_solicitud;
	}

	public void setId_sub_tipo_solicitud(Integer id_sub_tipo_solicitud) {
		this.id_sub_tipo_solicitud = id_sub_tipo_solicitud;
	}

	public Integer getId_complejidad_servicio() {
		return id_complejidad_servicio;
	}

	public void setId_complejidad_servicio(Integer id_complejidad_servicio) {
		this.id_complejidad_servicio = id_complejidad_servicio;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getSubtabla() {
		return subtabla;
	}

	public void setSubtabla(String subtabla) {
		this.subtabla = subtabla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Integer getId_padre() {
		return id_padre;
	}

	public void setId_padre(Integer id_padre) {
		this.id_padre = id_padre;
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
