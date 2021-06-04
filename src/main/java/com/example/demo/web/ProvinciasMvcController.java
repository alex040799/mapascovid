package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Mapas;
import com.example.demo.model.Provincias;
import com.example.demo.service.ProvinciasService;

/**
 * Clase que contiene los metodos necesarios para devolver los datos requeridos
 * en las peticiones web.
 * 
 * @author Alejandro
 *
 */

@Controller
@RequestMapping("/provincias")
public class ProvinciasMvcController 
{

	@Autowired
	ProvinciasService provinciaservice;
	
	/**
	 * Metodo que devulve una lista con todas las provincias.
	 */
	@RequestMapping
	public String getAllProvincias(Model model) 
	{	
		List<Provincias> listprovincias = provinciaservice.getAllProvincias();
		model.addAttribute("provincias", listprovincias);
		
		return "provincias";
	}
	
	/**
	 * Metodo que obtiene los datos de la provincia a partir de su nombre
	 * @param nombre Un string que contiene el nombre de la provincia de la que se va a obtener los datos.
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(path = "/obtenerUnDato")
	@ResponseBody
	public Provincias obtenerProvinciaByNombre(String nombre) 
							throws RecordNotFoundException 
	{
		return provinciaservice.getProvinciaByNombre(nombre);	
	}
	
	/**
	 * Metodo para añadir una nueva provincia
	 * @param provincia Un objeto Provincias que contiene los datos de la nueva provincia
	 * @return
	 */
	@PostMapping("/addNewProvincia")
	public String addNewProvincia(Provincias provincia) 
	{
		provinciaservice.addNewProvincia(provincia);
		return "redirect:/provincias";
	}
	
	/**
	 * Metodo para actualizar los datos de la provincia
	 * @param provincia Un objeto Provincias que contiene los datos de la provincia a actualizar.
	 */
	@RequestMapping(value="/updateProvincia", method = {RequestMethod.POST, RequestMethod.GET})
	public String updateProvincia(Provincias provincia) {
		provinciaservice.updateProvincia(provincia);
		return "redirect:/provincias";
	}

}

