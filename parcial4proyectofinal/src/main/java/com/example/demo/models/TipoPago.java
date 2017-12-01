package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class TipoPago {
	private int idtipo_pago;
	private String nombre_tipopago;
	private int monto_pago;

public TipoPago() {
	super();
}

public TipoPago(int idtipo_pago, String nombre_tipopago,int monto_pago ) {
	this.idtipo_pago=idtipo_pago;
	this.nombre_tipopago=nombre_tipopago;
	this.monto_pago=monto_pago;
	
}

public int getIdtipo_pago() {
	return idtipo_pago;
}

public void setIdtipo_pago(int idtipo_pago) {
	this.idtipo_pago = idtipo_pago;
}

public String getNombre_tipopago() {
	return nombre_tipopago;
}

public void setNombre_tipopago(String nombre_tipopago) {
	this.nombre_tipopago = nombre_tipopago;
}

public int getMonto_pago() {
	return monto_pago;
}

public void setMonto_pago(int monto_pago) {
	this.monto_pago = monto_pago;
}

}
