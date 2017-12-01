package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)

public class Sucursales {
private int idsucursal;
private String nombreSucursal;

public Sucursales() {
	super();
}
public Sucursales(int idsucursales, String nombreSucursal) {
	this.idsucursal=idsucursales;
	this.nombreSucursal=nombreSucursal;
}
public int getIdsucursal() {
	return idsucursal;
}
public void setIdsucursal(int idsucursal) {
	this.idsucursal = idsucursal;
}
public String getNombreSucursal() {
	return nombreSucursal;
}
public void setNombreSucursal(String nombreSucursal) {
	this.nombreSucursal = nombreSucursal;
}
}
