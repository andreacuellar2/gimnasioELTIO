package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Empleados {
	private int id_empleado;
	private String nombre_empleado;
	private int id_sucursal;
	private String pass_empleado;
	
	public Empleados() {
		super();
	}
	public Empleados(int id_empleado, String nombre_empleado,int id_sucursal,String pass_empleado) {
		super();
		this.id_empleado = id_empleado;
		this.nombre_empleado = nombre_empleado;
		this.id_sucursal = id_sucursal;
		this.pass_empleado = pass_empleado;
	}

	public int getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getNombre_empleado() {
		return nombre_empleado;
	}
	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}
	public int getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}
	public String getPass_empleado() {
		return pass_empleado;
	}
	public void setPass_empleado(String pass_empleado) {
		this.pass_empleado = pass_empleado;
	}
	@Override
	public String toString() {
		return "Empleado [ID del Empleado=" + id_empleado + ", nombre=" + nombre_empleado + ", idSucursal="+id_sucursal+", contraseña="+pass_empleado+"]";
	}
}
