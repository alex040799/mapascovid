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
import com.example.demo.service.MapasService;

/**
 * Clase que contiene los metodos necesarios para devolver los datos requeridos
 * en las peticiones web.
 * 
 * @author Alejandro
 *
 */

@Controller
@RequestMapping("/mapas")
public class MapasMvcController 
{

	@Autowired
	MapasService mapaservice;
	
	/**
	 * Método que devuelve una lista con todos los mapas.
	 */
	@RequestMapping
	public String getAllMapas(Model model) 
	{	
		List<Mapas> listmapas = mapaservice.getAllMapas();
		model.addAttribute("mapas", listmapas);
		
		return "mapas";
	}
	
	/**
	 * Metodo que obtiene los datos de un mapa a partir de su id.
	 * @param id Un integer que contiene el id del mapa del que se va a obtener los datos.
	 * @throws RecordNotFoundException
	 */
	
	@RequestMapping(path = "/obtenerUnDato")
	@ResponseBody
	public Optional<Mapas> obtenerMapayId(Integer id) 
							throws RecordNotFoundException 
	{
		return mapaservice.getById(id);		
	}
	
	/**
	 * Metodo para añadir un nuevo mapa
	 * @param mapa Un objeto Mapas que contiene los datos del nuevo mapa.
	 */
	@PostMapping("/addNewMapa")
	public String addNewOrder(Mapas mapa) 
	{
		mapaservice.addNewMapa(mapa);
		return "redirect:/mapas";
	}
	
	/**
	 * Metodo para actualizar los datos de un mapa
	 * @param mapa Un objeto Mapas que contiene los datos del mapa a actualizar
	 */
	@RequestMapping(value="/updateMapa", method = {RequestMethod.POST, RequestMethod.GET})
	public String updateMapa(Mapas mapa) {
		mapaservice.updateMapa(mapa);
		return "redirect:/mapas";
	}

	/**
	 * Metodo para eliminar un mapa a partir de su id
	 * @param id Un integer que contiene el id del mapa a eliminar
	 * @return
	 */
	@RequestMapping(value="/deleteMapa", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteMapa(Integer id){
		mapaservice.deleteMapa(id);
		return "redirect:/mapas";
	}
}

