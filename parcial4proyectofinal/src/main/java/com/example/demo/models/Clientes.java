package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Clientes {
	private int id_cliente;
	private String nombre_cliente;
	private String genero_cliente;
	private int id_sucursalcliente;
	
	public Clientes() {
		super();
	}
	
	public Clientes(int id_cliente, String nombre_cliente, String genero_cliente, boolean activo_cliente, int id_sucursalcliente) {
	this.id_cliente=id_cliente;
	this.nombre_cliente=nombre_cliente;
	this.genero_cliente=genero_cliente;
	this.id_sucursalcliente=id_sucursalcliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getGenero_cliente() {
		return genero_cliente;
	}

	public void setGenero_cliente(String genero_cliente) {
		this.genero_cliente = genero_cliente;
	}
	public int getId_sucursalcliente() {
		return id_sucursalcliente;
	}

	public void setId_sucursalcliente(int id_sucursalcliente) {
		this.id_sucursalcliente = id_sucursalcliente;
	}
	
	}


