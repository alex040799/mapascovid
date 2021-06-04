package com.example.demo.web;

import java.util.ArrayList;
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
import com.example.demo.model.DatosLocalidades;
import com.example.demo.model.DatosMapa;
import com.example.demo.model.DatosMapaTabla;
import com.example.demo.model.Localidades;
import com.example.demo.model.Mapas;
import com.example.demo.model.Provincias;
import com.example.demo.service.DatosMapaService;
import com.example.demo.service.LocalidadesService;
import com.example.demo.service.MapasService;
import com.example.demo.service.ProvinciasService;

/**
 * Clase que contiene los metodos necesarios para devolver los datos requeridos
 * en las peticiones web.
 * 
 * @author Alejandro
 *
 */

@Controller
@RequestMapping("/")
public class IndexMvcController {

	// Un arraylist que contiene los datos del mapa que se procesa.
	static ArrayList<DatosMapaTabla> datosMapas = new ArrayList<DatosMapaTabla>();

	@Autowired
	LocalidadesService service;

	@Autowired
	ProvinciasService provinciaservice;

	@Autowired
	MapasService mapasService;

	@Autowired
	DatosMapaService datosmapaservice;

	@Autowired
	LocalidadesService localidadeservice;

	/**
	 * Metodo para obtener todos los datos a mostrar en la pagína de index.
	 */
	@RequestMapping
	public String getAllDatosIndex(Model model) 
	{
		//Obtenemos un lista con todas las provincias y todos los mapas.
		List<Provincias> list = provinciaservice.getAllProvincias();
		List<Mapas> listMapas = mapasService.getAllMapas();

		model.addAttribute("mapas", listMapas);
		model.addAttribute("select", list);

		return "index";
	}

	/**
	 * Metodo para obtener un arraylist con todos los datos de un mapa a partir del id del mapa y la provincia seleccionada.
	 * @param provincia Un string que contiene la provincia seleccionada en el select.
	 * @param mapa Un integer que contiene el id del mapa seleccionado en el select.
	 * @throws RecordNotFoundException
	 */
	@GetMapping(value = "/obtenerUnDato")
	public String getByProvinciaAndMapa(Model model, String provincia, Integer mapa, RedirectAttributes redir)
			throws RecordNotFoundException 
	{
		Integer idLocalidad, casos, id, idMapa; // Integer con contiene el id de la localidad, casos, id del dato y el id del mapa.
		String nombreMapa, nombreLocalidad;	// String que contiene el nombre del mapa y de la localidad
		
		//Obtiene un lista con todos los datos de la localidades
		List<DatosLocalidades> list = service.getAllLocalidadesByProvinciaAndMapa(provincia, mapa);

		//Obtiene el tipo de mapa seleccionado
		String tipoMapa = mapasService.getTipoMapa(mapa);

		//Obtiene los datos de la provincia seleccionada
		Provincias datosProvincia = provinciaservice.getProvinciaByNombre(provincia);

		redir.addFlashAttribute("latitudProvincia", datosProvincia.getLatitud());
		redir.addFlashAttribute("longitudProvincia", datosProvincia.getLongitud());
		redir.addFlashAttribute("markers", list);
		redir.addFlashAttribute("tipoMapa", tipoMapa);

		//Un arraylist con los datos del mapa a partir del mapa y provincia seleccionados
		List<DatosMapa> result = (List<DatosMapa>) datosmapaservice.getAllDatosMapasPorProvincia(mapa, provincia);

		datosMapas = new ArrayList<DatosMapaTabla>();

		for (int i = 0; i < result.size(); i++) {

			id = result.get(i).getId();
			idMapa = result.get(i).getIdMapa();
			idLocalidad = result.get(i).getIdLocalidad();
			nombreLocalidad = localidadeservice.getNombreLocalidad(idLocalidad);
			casos = result.get(i).getCasos();

			DatosMapaTabla datosMapaTabla = new DatosMapaTabla();
			datosMapaTabla.setId(id);
			datosMapaTabla.setMapa(idMapa);
			datosMapaTabla.setLocalidad(nombreLocalidad);
			datosMapaTabla.setCasos(casos);

			datosMapas.add(datosMapaTabla);

			System.out.print(nombreLocalidad);
		}

		redir.addFlashAttribute("datosmapas", datosMapas);

		return "redirect:/";
	}
}
