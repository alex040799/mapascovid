package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.DatosMapa;
import com.example.demo.model.DatosMapaTabla;
import com.example.demo.model.Localidades;
import com.example.demo.model.Mapas;
import com.example.demo.model.Provincias;
import com.example.demo.service.DatosMapaService;
import com.example.demo.service.LocalidadesService;
import com.example.demo.service.MapasService;

/**
 * Clase que contiene los metodos necesarios para devolver los datos requeridos
 * en las peticiones web.
 * 
 * @author Alejandro
 *
 */

@Controller
@RequestMapping("/datosmapas")
public class DatosMapaMvcController {
	// Un integer que contiene el id del mapa.
	static Integer idMapa = 0;

	// Un arraylist que contiene los datos del mapa que se procesa.
	static ArrayList<DatosMapaTabla> datosMapas = new ArrayList<DatosMapaTabla>();

	@Autowired
	LocalidadesService service;

	@Autowired
	DatosMapaService datosmapaservice;

	@Autowired
	LocalidadesService localidadeservice;

	@Autowired
	MapasService mapaservice;

	/**
	 * Metodo para obtener los datos de un mapa a partir de su id.
	 * 
	 * @param id Un integer que contiene el id del mapa
	 * @return Devuelve un objeto datosMapaTabla con sus datos obtenidos a partir
	 *         del id del mapa.
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(path = "/obtenerUnDato")
	@ResponseBody
	public DatosMapaTabla obtenerDatosMapaById(Integer id) throws RecordNotFoundException 
	{
		return datosmapaservice.getById(datosMapas, id);
	}

	/**
	 * Metodo para obtener los datos de un mapa
	 * @param mapa Un integer con el id del mapa
	 * @throws RecordNotFoundException
	 */
	@GetMapping(value="/obtenerDatosMapas")
	public String obtenerDatosMapaByMapa(Model model, Integer mapa, RedirectAttributes redir) 
							throws RecordNotFoundException 
	{
	
		idMapa = mapa;
		
		Integer idLocalidad, casos, id2, idMapa;		
		String nombreMapa, nombreLocalidad;
		
		List<DatosMapa> result = (List<DatosMapa>) datosmapaservice.getAllDatosMapasPorMapa(mapa);
				
				datosMapas = new ArrayList<DatosMapaTabla>();
				
				for (int i = 0; i < result.size(); i++) {
					
					id2 = result.get(i).getId();
					idMapa = result.get(i).getIdMapa();
					idLocalidad = result.get(i).getIdLocalidad();
					nombreLocalidad = localidadeservice.getNombreLocalidad(idLocalidad);
					casos = result.get(i).getCasos();
					
					DatosMapaTabla datosMapaTabla = new DatosMapaTabla();
					datosMapaTabla.setId(id2);
					datosMapaTabla.setMapa(idMapa);
					datosMapaTabla.setLocalidad(nombreLocalidad);
					datosMapaTabla.setCasos(casos);
					
					datosMapas.add(datosMapaTabla);
					
					System.out.print(nombreLocalidad);
				}
			
				redir.addFlashAttribute("datosmapas", datosMapas);
				
				return "redirect:/datosmapas";
	}

	/**
	 * Metodo para obtener todos los datos de todos los mapas.
	 */
	@RequestMapping
	public String getAllDatosMapasTabla(Model model) 
	{
		Integer idLocalidad, casos, id, mapa;// Integer con contiene el id de la localidad, casos, id del dato y el id del mapa.
		String nombreMapa, nombreLocalidad;	// String que contiene el nombre del mapa y de la localidad

		List<Mapas> listmapas = mapaservice.getAllMapas();
		model.addAttribute("mapas", listmapas);

		List<Localidades> listlocalides = service.getAllLocalidades();
		model.addAttribute("localidades", listlocalides);

		//Comprobamos que el id del mapa es el 0, si es 0 mostrará todos los datos de todos los mapas.
		if (idMapa == 0) {

			List<DatosMapa> result = (List<DatosMapa>) datosmapaservice.getAllDatosMapas();

			datosMapas = new ArrayList<DatosMapaTabla>();

			for (int i = 0; i < result.size(); i++) {

				id = result.get(i).getId();
				mapa = result.get(i).getIdMapa();
				idLocalidad = result.get(i).getIdLocalidad();
				nombreLocalidad = localidadeservice.getNombreLocalidad(idLocalidad);
				casos = result.get(i).getCasos();

				DatosMapaTabla datosMapaTabla = new DatosMapaTabla();
				datosMapaTabla.setId(id);
				datosMapaTabla.setMapa(mapa);
				datosMapaTabla.setLocalidad(nombreLocalidad);
				datosMapaTabla.setCasos(casos);

				datosMapas.add(datosMapaTabla);

				System.out.print(nombreLocalidad);
			}
			model.addAttribute("datosmapas", datosMapas);
		}

		return "datosMapa";
	}

	/**
	 * Metodo para actualizar los datos de un objeto DatosMapaTabla
	 * @param datosMapa Un objeto de tipo DatosMapaTabla con todos sus datos.
	 */
	@RequestMapping(value = "/updatedatosMapa", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateDatosMapa(DatosMapaTabla datosMapa) 
	{
		//Obtenemos el id de la localidad a partir del nombre de la localidad
		Integer idLocalidad = service.getIdByNombre(datosMapa.getLocalidad());
		datosmapaservice.updateDatosMapa(datosMapa, idLocalidad);
		idMapa = 0;
		return "redirect:/datosmapas";
	}

	/**
	 * Metodo para añadir un nuevo datos a un mapa
	 * @param datosmapa Un objeto de tipo DatosMapa con todos sus datos.
	 */
	@PostMapping("/addNewdatosMapa")
	public String addNewDatosMapa(DatosMapa datosmapa) 
	{
		datosmapaservice.addNewdatosMapa(datosmapa);
		idMapa = 0;
		return "redirect:/datosmapas";
	}

	/**
	 * Metodo para eliminar un dato de un mapa
	 * @param id Un integer que contiene el id del dato del mapa a eliminar
	 */
	@RequestMapping(value = "/deletedatosMapa", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteDatosMapa(Integer id) 
	{
		datosmapaservice.deletedatosMapa(id);
		idMapa = 0;
		return "redirect:/datosmapas";
	}
}
