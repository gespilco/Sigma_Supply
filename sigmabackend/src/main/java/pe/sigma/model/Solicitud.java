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
@Table(name = "solicitud")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_solicitud;
	
	@Column(name = "numero_solicitud", nullable = true, length = 70)
	private String numero_solicitud;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = true)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_solicitud", nullable = true)
	private TipoSolicitud tipo_solicitud;
	
	@Column(name = "descripcion", nullable = true, length = 400)
	private String descripcion;

	
	@ManyToOne
	@JoinColumn(name = "id_zona", nullable = true)
	private Zona zona;
	
	@Column(name = "direccion", nullable = true, length = 200)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_prioridad", nullable = true)
	private TipoPrioridad tipo_prioridad;
	
	@ManyToOne
	@JoinColumn(name = "id_sub_tipo_solicitud", nullable = true)
	private SubTipoSolicitud sub_tipo_solicitud;
	
	@ManyToOne
	@JoinColumn(name = "id_complejidad_servicio", nullable = true)
	private ComplejidadServicio complejidad_servicio;

	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_hora_inicio;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_hora_fin;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_registro;
	
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

	public Integer getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Integer id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public String getNumero_solicitud() {
		return numero_solicitud;
	}

	public void setNumero_solicitud(String numero_solicitud) {
		this.numero_solicitud = numero_solicitud;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoSolicitud getTipo_solicitud() {
		return tipo_solicitud;
	}

	public void setTipo_solicitud(TipoSolicitud tipo_solicitud) {
		this.tipo_solicitud = tipo_solicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoPrioridad gettipo_prioridad() {
		return tipo_prioridad;
	}

	public void settipo_prioridad(TipoPrioridad tipo_prioridad) {
		this.tipo_prioridad = tipo_prioridad;
	}

	public SubTipoSolicitud getsub_tipo_solicitud() {
		return sub_tipo_solicitud;
	}

	public void setsub_tipo_solicitud(SubTipoSolicitud sub_tipo_solicitud) {
		this.sub_tipo_solicitud = sub_tipo_solicitud;
	}

	public ComplejidadServicio getComplejidad_servicio() {
		return complejidad_servicio;
	}

	public void setComplejidad_servicio(ComplejidadServicio complejidad_servicio) {
		this.complejidad_servicio = complejidad_servicio;
	}

	public LocalDateTime getFecha_hora_inicio() {
		return fecha_hora_inicio;
	}

	public void setFecha_hora_inicio(LocalDateTime fecha_hora_inicio) {
		this.fecha_hora_inicio = fecha_hora_inicio;
	}

	public LocalDateTime getFecha_hora_fin() {
		return fecha_hora_fin;
	}

	public void setFecha_hora_fin(LocalDateTime fecha_hora_fin) {
		this.fecha_hora_fin = fecha_hora_fin;
	}

	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
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
