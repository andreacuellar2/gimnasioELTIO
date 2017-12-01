package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pagos {
	private int idpago;
	private int idcliente;
	private int idTipoPago;
	private String fecha;
	
	public Pagos() {
		super();
	}
	public Pagos(int idpago, int idcliente, int idTipoPago, String fecha) {
		this.idpago=idpago;
		this.idcliente=idcliente;
		this.idTipoPago=idTipoPago;
		this.fecha=fecha;
	}
	
	public int getIdpago() {
		return idpago;
	}
	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdTipoPago() {
		return idTipoPago;
	}
	public void setIdTipoPago(int idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	


}

