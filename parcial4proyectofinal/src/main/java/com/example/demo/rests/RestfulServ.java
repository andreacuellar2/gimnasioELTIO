package com.example.demo.rests;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.Clientes;
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
		return new ArrayList<Empleados>(Arrays.asList(restService.getForObject(apiUrl+"/empleadoController/getEmpleado", Empleados[].class)));
	}
	public ArrayList<Pagos> getAllPagos() {
		return new ArrayList<Pagos>(Arrays.asList(restService.getForObject(apiUrl+"/pagoController/getPago", Pagos[].class)));
	}
	public ArrayList<Sucursales> getAllSucursales() {
		return new ArrayList<Sucursales>(Arrays.asList(restService.getForObject(apiUrl+"/sucursalController/getSucursal", Sucursales[].class)));
	}
	public ArrayList<Clientes> getAllClientes() {
		return new ArrayList<Clientes>(Arrays.asList(restService.getForObject(apiUrl+"/clienteController/getCliente", Clientes[].class)));
	}
	
	
}
