package com.werentmedellin.generadorcontratos.domain.dto;

import java.io.Serializable;




public class CuentaDTO  implements Serializable{

	private Long id;
	private String numeroCuenta;
	//private Banco banco;
	//private TipoCuenta tipoCuenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/*public Banco getBanco() {
	 	return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
*/
	
	
	

}
