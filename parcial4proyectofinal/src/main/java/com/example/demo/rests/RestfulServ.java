package com.example.demo.rests;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Empleados;
import com.example.demo.models.Pagos;
import com.example.demo.models.Sucursales;

@Service
public class RestfulServ {

	private RestTemplate restService;
	
	@Value("${apiUrl}")
	private String apiUrl;
	
	private RestfulServ() {
		restService = new RestTemplate();
	}
	
	public ArrayList<Empleados> getAllEmpleados() {
		System.out.println(Arrays.asList(restService.getForObject(apiUrl+"/empleadoController/getEmpleado", Empleados[].class)));
		return new ArrayList<Empleados>(Arrays.asList(restService.getForObject(apiUrl+"/empleadoController/getEmpleado", Empleados[].class)));
	}
	public ArrayList<Pagos> getAllPagos() {
		System.out.println(Arrays.asList(restService.getForObject(apiUrl+"/pagoController/getPago", Pagos[].class)));
		return new ArrayList<Pagos>(Arrays.asList(restService.getForObject(apiUrl+"/pagoController/getPago", Pagos[].class)));
	}
	public ArrayList<Sucursales> getAllSucursales() {
		System.out.println(Arrays.asList(restService.getForObject(apiUrl+"/sucursalController/getSucursal", Sucursales[].class)));
		return new ArrayList<Sucursales>(Arrays.asList(restService.getForObject(apiUrl+"/sucursalController/getSucursal", Sucursales[].class)));
	}
	
	
	
}
