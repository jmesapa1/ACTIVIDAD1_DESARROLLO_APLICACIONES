package com.werentmedellin.generadorcontratos.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.werentmedellin.generadorcontratos.persistence.crud.PropietarioRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="inmuebles")
public class Inmueble  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inmueble")
	private Long idInmueble;
	@Column(name="direccion")
	private String direccion;
	@Column(name="apartamento_flag")
	private Boolean apartamentoFlag;
	@Column(name="apartamento")
	private String apartamento;
	@Column(name="casa_flag")
	private Boolean casaFlag;
	@Column(name="casa")
	private String casa;
	@Column(name="urbanizacion_flag")
	private Boolean urbanizacionFlag;
	@Column(name="urbanizacion")
	private String urbanizacion;
	@Column(name="parqueadero_flag")
	private Boolean ParqueaderoFlag;
	@Column(name="parqueadero")
	private String parqueadero;
	@Column(name="cuarto_util_flag")
	private Boolean cuartoUtilFlag;
	@Column(name="cuarto_util")
	private String cuartoUtil;
	@Column(name="municipio")
	private String municipio;
	@Column(name="departamento")
	private String departamento;

	@JsonIgnoreProperties("inmueble")
	@OneToMany(mappedBy = "inmueble", cascade = {CascadeType.ALL})
    private List<Contrato> contratos;


	public Inmueble(){
		super();
	}
	

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


	public Long getIdInmueble() {
		return idInmueble;
	}


	public void setIdInmueble(Long idInmueble) {
		this.idInmueble = idInmueble;
	}


	public List<Contrato> getContratos() {
		return contratos;
	}


	public void setContratos(List<Contrato> contrato) {
		this.contratos = contrato;
	}


	


	
}
