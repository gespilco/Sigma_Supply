package pe.sigma.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "programacion")
public class Programacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_programacion;

//	@OneToOne
//	@JoinColumn(name = "id_visita", nullable = true)
//	private Visita visita;

	@Column(name = "programacion", nullable = true, length = 200)
	private String programacion;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha_programada;

	@Column(name = "acepta_tecnico", nullable = true)
	private boolean acepta_tecnico;

	@Column(name = "acepta_cliente", nullable = true)
	private boolean acepta_cliente;

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

	public Integer getId_programacion() {
		return id_programacion;
	}

	public void setId_programacion(Integer id_programacion) {
		this.id_programacion = id_programacion;
	}

//	public Visita getVisita() {
//		return visita;
//	}
//
//	public void setVisita(Visita visita) {
//		this.visita = visita;
//	}

	public String getProgramacion() {
		return programacion;
	}

	public void setProgramacion(String programacion) {
		this.programacion = programacion;
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
