package com.werentmedellin.generadorcontratos.domain.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.werentmedellin.generadorcontratos.persistence.entity.Agencia;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ContratoDTO {

	@Min(value = 1, message = "formato o valor inválido")
	private Long idContrato;

	@NotNull(message = "fecha de creación no puede estar en blanco")
	private Date fechaCreacion;
	@NotNull(message = "fecha de inicio no puede estar en blanco")
	private Date fechaInicio;
	@NotNull(message = "fecha de fin no puede estar en blanco")
	private Date fechaFin;

	@NotNull(message = "Canon no puede estar en blanco")
	@Min(value = 1, message = "El canon debe ser mayor a $1")
	private Long canon;

	@Max(value = 100, message = "La comisión debe ser menor a 100")
	@Min(value = 1, message = "La comisión debe ser mayor a 1")
	@NotNull(message = "Comisión no puede estar en blanco")
	private Long comision;

	private InmuebleDTO inmueble;
	private PropietarioDTO propietario;

	private AgenciaDTO agencia;

	@Max(value = 100, message = "La comisión debe ser menor a 100")
	@Min(value = 1, message = "La comisión debe ser mayor a 1")
	@NotNull(message = "debe enviarse la informacion de la agencia")
	private Long duracionMeses;
	
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

	public InmuebleDTO getInmueble() {
		return inmueble;
	}

	public void setInmueble(InmuebleDTO inmueble) {
		this.inmueble = inmueble;
	}

	public AgenciaDTO getAgencia() {
		return agencia;
	}

	public void setAgencia(AgenciaDTO agencia) {
		this.agencia = agencia;
	}

	public Long getDuracionMeses() {
		return duracionMeses;
	}

	public void setDuracionMeses(Long duracionMeses) {
		this.duracionMeses = duracionMeses;
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

	public Long getId() {
		return idContrato;
	}

	public void setId(Long id) {
		this.idContrato = id;
	}

	public PropietarioDTO getPropietario() {
		return propietario;
	}

	public void setPropietario(PropietarioDTO propietario) {
		this.propietario = propietario;
	}

	
	
	
}
