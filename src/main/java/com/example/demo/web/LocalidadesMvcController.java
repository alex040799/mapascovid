package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Localidades;
import com.example.demo.model.Provincias;
import com.example.demo.service.LocalidadesService;
import com.example.demo.service.ProvinciasService;

/**
 * Clase que contiene los metodos necesarios para devolver los datos requeridos
 * en las peticiones web.
 * 
 * @author Alejandro
 *
 */
@Controller
@RequestMapping("/localidades")
public class LocalidadesMvcController 
{
	@Autowired
	LocalidadesService service;
	
	@Autowired
	ProvinciasService provinciaservice;

	/**
	 * Metodo que devuelve una lista con las localidades y provincias
	 */
	@RequestMapping
	public String getAllDatos(Model model) 
	{
		List<Localidades> listlocalidades = service.getAllLocalidades();
		model.addAttribute("localidades",  listlocalidades);
		
		List<Provincias> listprovincias = provinciaservice.getAllProvincias();
		model.addAttribute("provincias", listprovincias);
		
		return "localidades";
	}
	
	/**
	 * Metodo que devuelve los datos de una localidad a partir de su id.
	 * @param id Un integer que contiene el id de la localidad
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(path = "/obtenerUnDato")
	@ResponseBody
	public Optional<Localidades> obtenerLocalidadById(Integer id) 
							throws RecordNotFoundException 
	{
			return service.getById(id);	
	}
	
	/**
	 * Metodo para actualizar los datos de la localidad
	 * @param localidad Un objeto Localidades que contiene los datos de la localidad a actualizar datos.
	 * @return
	 */
	@RequestMapping(value="/updateLocalidad", method = {RequestMethod.POST, RequestMethod.GET})
	public String updateLocalidad(Localidades localidad) {
		service.updateLocalidad(localidad);
		return "redirect:/localidades";
	}

}

