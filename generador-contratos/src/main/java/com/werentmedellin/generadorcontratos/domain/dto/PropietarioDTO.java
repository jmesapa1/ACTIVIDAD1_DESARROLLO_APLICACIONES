package com.werentmedellin.generadorcontratos.domain.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public class PropietarioDTO implements Serializable {

    private Long idPropietario;
    @NotNull(message = "primer nombre de propietario no puede estar en blanco")
    private String primerNombre;
    private String segundoNombre;
    @NotNull(message = "primer apellido de propietario no puede estar en blanco")
    private String primerApellido;
    private String segundoApellido;
    @NotNull(message = "cedula de propietario no puede estar en blanco")
    private String cedula;

    private List<ContratoDTO> contratos;

    private CuentaDTO cuenta;

   
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public CuentaDTO getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaDTO cuenta) {
        this.cuenta = cuenta;
    }

    public List<ContratoDTO> getContratos() {
        return contratos;
    }

    public void setContratos(List<ContratoDTO> contratos) {
        this.contratos = contratos;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

}
