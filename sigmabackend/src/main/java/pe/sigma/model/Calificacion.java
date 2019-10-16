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
@Table(name = "calificacion")
public class Calificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_calificacion;

	@ManyToOne
	@JoinColumn(name = "id_tecnico", nullable = true)
	private Tecnico tecnico;

	@Column(name = "mes", nullable = true, length = 300)
	private String mes;
	
	@Column(name = "calificacion_cliente", nullable = true)
	private double calificacion_cliente;
	
	@Column(name = "calificacion_coodinador", nullable = true)
	private double calificacion_coodinador;
	
	@Column(name = "valor", nullable = true)
	private double valor;
	
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
	
	public Integer getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(Integer id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public double getCalificacion_cliente() {
		return calificacion_cliente;
	}
	public void setCalificacion_cliente(double calificacion_cliente) {
		this.calificacion_cliente = calificacion_cliente;
	}
	public double getCalificacion_coodinador() {
		return calificacion_coodinador;
	}
	public void setCalificacion_coodinador(double calificacion_coodinador) {
		this.calificacion_coodinador = calificacion_coodinador;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
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
