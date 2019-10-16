package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "hoja_ruta")
public class HojaRuta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_hoja_ruta;

	@OneToOne
	@JoinColumn(name = "id_programa_visita", nullable = true)
	private ProgramaVisita programaVisita;
		
	@ManyToOne
	@JoinColumn(name = "id_orden_servicio", nullable = true)
	private OrdenServicio ordenServicio;

	@Column(name = "descripcion", nullable = true, length = 300)
	private String descripcion;

	@Column(name = "ubicacion", nullable = true, length = 300)
	private String ubicacion;
	
	@Column(name = "longitud", nullable = true)
	private Double longitud;
	
	@Column(name = "latitud", nullable = true)
	private Double latitud;

	@Column(name = "referencia_ruta", nullable = true, length = 300)
	private String referencia_ruta;

	@Column(name = "orden", nullable = true)
	private Integer orden;
	
	@Column(name = "orden_registro", nullable = true)
	private Integer orden_registro;

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

	public Integer getId_hoja_ruta() {
		return id_hoja_ruta;
	}

	public void setId_hoja_ruta(Integer id_hoja_ruta) {
		this.id_hoja_ruta = id_hoja_ruta;
	}

	public ProgramaVisita getProgramaVisita() {
		return programaVisita;
	}

	public void setProgramaVisita(ProgramaVisita programaVisita) {
		this.programaVisita = programaVisita;
	}

	public OrdenServicio getOrdenServicio() {
		return ordenServicio;
	}

	public void setOrdenServicio(OrdenServicio ordenServicio) {
		this.ordenServicio = ordenServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public String getReferencia_ruta() {
		return referencia_ruta;
	}

	public void setReferencia_ruta(String referencia_ruta) {
		this.referencia_ruta = referencia_ruta;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getOrden_registro() {
		return orden_registro;
	}

	public void setOrden_registro(Integer orden_registro) {
		this.orden_registro = orden_registro;
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
