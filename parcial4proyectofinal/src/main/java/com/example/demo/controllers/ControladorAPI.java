package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;



import com.example.demo.rests.RestfulServ;

@Controller
public class ControladorAPI {
	@Autowired
	RestfulServ rest;
	
	@GetMapping("/")
	public String getAllBrands(ModelMap model,@CookieValue(value="usuario",required=false) String cookie) {
		if (cookie == null) {
			return "login";
	}else {
		System.out.println("entro");
		model.addAttribute("listaTodoslosEmpleados",rest.getAllEmpleados());
		model.addAttribute("listaTodosPagos",rest.getAllPagos());
		model.addAttribute("listaTodasSucursales",rest.getAllSucursales());
		model.addAttribute("listaTodosClientes",rest.getAllClientes());
		model.addAttribute("listaTipodePagos",rest.getAllTiposPagos());
		return "index";
	}
}
}

