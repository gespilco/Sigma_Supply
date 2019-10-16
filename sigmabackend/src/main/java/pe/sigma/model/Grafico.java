package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "grafico")
public class Grafico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_grafico;
	
	@Column(name = "id_tecnico", nullable = true)
	private Integer id_tecnico;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_programada;
	
	@Column(name = "recurso", nullable = true, length = 300)
	private String recurso;
	
	@Column(name = "nombre", nullable = true, length = 300)
	private String nombre;
	
	@Column(name = "ubicacion", nullable = true, length = 300)
	private String ubicacion;
	
	@Column(name = "source", nullable = true)
	private Integer source;
	
	@Column(name = "target", nullable = true)
	private Integer target;
	
	@Column(name = "cost", nullable = true)
	private double cost;
	
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

	public Integer getId_grafico() {
		return id_grafico;
	}

	public void setId_grafico(Integer id_grafico) {
		this.id_grafico = id_grafico;
	}

	public Integer getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(Integer id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public LocalDateTime getFecha_programada() {
		return fecha_programada;
	}

	public void setFecha_programada(LocalDateTime fecha_programada) {
		this.fecha_programada = fecha_programada;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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
