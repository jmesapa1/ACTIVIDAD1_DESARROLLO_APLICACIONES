package com.werentmedellin.generadorcontratos.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="propietarios")
public class Propietario  implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_propietario")
    private Long idPropietario;
    @Column(name="primer_nombre")
    private String primerNombre;
    @Column(name="segundo_nombre")
    private String segundoNombre;
    @Column(name="primer_apellido")
    private String primerApellido;
    @Column(name="segundo_apellido")
    private String segundoApellido;
    @Column(name="cedula")
    private String cedula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;

    @JsonIgnoreProperties({"propietario","contratos"})
	@OneToMany(mappedBy = "propietario", cascade = {CascadeType.ALL})
    private List<Contrato> contratos;

    public Propietario (){
        this.contratos = new ArrayList<>();
    }

    public Long getId() {
        return idPropietario;
    }

    public void setId(Long id) {
        this.idPropietario = id;
    }

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

   

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    

}
