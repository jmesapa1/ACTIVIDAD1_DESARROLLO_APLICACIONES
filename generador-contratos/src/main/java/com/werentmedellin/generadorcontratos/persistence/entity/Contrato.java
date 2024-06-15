package com.werentmedellin.generadorcontratos.persistence.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="contratos")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha_creacion", nullable = false)
	private Date fechaCreacion;
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@Column(name="fecha_fin")
	private Date fechaFin;
	@Column(name="canon")
	private Long canon;
	@Column(name="comision")
	private Long comision;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	

	@JsonIgnoreProperties(value={"contratos","hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="id_inmueble", insertable = true, updatable = true)
	private Inmueble inmueble;
	

	@JsonIgnoreProperties(value={"agencia","hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="id_agencia",insertable = true, updatable = true)
	private Agencia agencia;

	@JsonIgnoreProperties(value={"contratos","hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="id_propietario",insertable = true, updatable = true)
	private Propietario propietario;
	
	private Long duracionMeses;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Inmueble getInmueble() {
		return inmueble;
	}



	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}



	public Agencia getAgencia() {
		return agencia;
	}



	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}



	public Long getDuracionMeses() {
		return duracionMeses;
	}



	public void setDuracionMeses(Long duracionMeses) {
		this.duracionMeses = duracionMeses;
	}
	


	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public Long getCanon() {
		return canon;
	}



	public void setCanon(Long canon) {
		this.canon = canon;
	}



	public Long getComision() {
		return comision;
	}



	public void setComision(Long comision) {
		this.comision = comision;
	}



	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}



	public Propietario getPropietario() {
		return propietario;
	}



	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}	
	
	
}
