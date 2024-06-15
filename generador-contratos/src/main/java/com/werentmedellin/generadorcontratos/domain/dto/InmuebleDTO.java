package com.werentmedellin.generadorcontratos.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InmuebleDTO   implements Serializable {

	@Min(value = 1, message = "formato o valor inválido")
	private Long idInmueble;
	
	@NotNull(message = "direccion de inmueble no puede estar en blanco")
	private String direccion;
	private Boolean apartamentoFlag;
	private String apartamento;
	private Boolean casaFlag;
	private String casa;
	private Boolean urbanizacionFlag;
	private String urbanizacion;
	private Boolean ParqueaderoFlag;
	private String parqueadero;
	private Boolean cuartoUtilFlag;
	private String cuartoUtil;
	@NotNull(message = "municipio de inmueble no puede estar en blanco")
	private String municipio;
	@NotNull(message = "departamento de inmueble no puede estar en blanco")
	private String departamento;
	
	
	private List<ContratoDTO> contratos ;

	

	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getApartamentoFlag() {
		return apartamentoFlag;
	}

	public void setApartamentoFlag(Boolean apartamentoFlag) {
		this.apartamentoFlag = apartamentoFlag;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public Boolean getCasaFlag() {
		return casaFlag;
	}

	public void setCasaFlag(Boolean casaFlag) {
		this.casaFlag = casaFlag;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public Boolean getUrbanizacionFlag() {
		return urbanizacionFlag;
	}

	public void setUrbanizacionFlag(Boolean urbanizacionFlag) {
		this.urbanizacionFlag = urbanizacionFlag;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public Boolean getParqueaderoFlag() {
		return ParqueaderoFlag;
	}

	public void setParqueaderoFlag(Boolean parqueaderoFlag) {
		ParqueaderoFlag = parqueaderoFlag;
	}

	public String getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(String parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Boolean getCuartoUtilFlag() {
		return cuartoUtilFlag;
	}

	public void setCuartoUtilFlag(Boolean cuartoUtilFlag) {
		this.cuartoUtilFlag = cuartoUtilFlag;
	}

	public String getCuartoUtil() {
		return cuartoUtil;
	}

	public void setCuartoUtil(String cuartoUtil) {
		this.cuartoUtil = cuartoUtil;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<ContratoDTO> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoDTO> contratos) {
		this.contratos = contratos;
	}

	public Long getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(Long idInmueble) {
		this.idInmueble = idInmueble;
	}	


	

	
	
}
