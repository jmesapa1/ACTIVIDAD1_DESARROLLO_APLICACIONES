package com.werentmedellin.generadorcontratos.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AgenciaDTO {
	
	@Min(value = 1, message = "formato o valor inválido")
	private Long id;
	@NotNull(message = "nombre de agencia no puede estar en blanco")
	private String nombre;
	@NotNull(message = "nombre de representante legal agencia no puede estar en blanco")
	private String nombreRepresentanteLegal;
	@NotNull(message = "nit de representante legal agencia no puede estar en blanco")
	private String nit;
	@NotNull(message = "dirección de agencia no puede estar en blanco")
	private String direccion;
	private String telefono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreRepresentanteLegal() {
		return nombreRepresentanteLegal;
	}

	public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
		this.nombreRepresentanteLegal = nombreRepresentanteLegal;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	
	

}
