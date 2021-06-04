package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.DatosMapa;
import com.example.demo.model.DatosMapaTabla;
import com.example.demo.model.Localidades;
import com.example.demo.model.Mapas;
import com.example.demo.repository.DatosMapaRepository;
import com.example.demo.repository.LocalidadesRepository;
import com.example.demo.repository.MapasRepository;

/**
 * Clase que contiene los metodos que obtienen los datos requeridos en el controller web de DatosMapa.
 * @author Alejandro
 *
 */

@Service
public class DatosMapaService {
	
	@Autowired
	DatosMapaRepository datosMaparepository;
	
	/**
	 * Metodo que obtiene todos los datos de los mapas.
	 * @return Devuelve un arraylist que contiene todos los datos de los mapas.
	 */
	public List<DatosMapa> getAllDatosMapas()
	{
		List<DatosMapa> result = (List<DatosMapa>) datosMaparepository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DatosMapa>();
		}
	}
	
	/**
	 * Metodo que devuelve todos los datos de un mapa a partir del id del mapa y la provincia.
	 * @param idMapa Un integer que contiene el id del mapa.
	 * @param provincia Un string que contiene el nombre de la provincia.
	 * @return Devuelve un arraylist que contiene los datos del mapa.
	 */
	public List<DatosMapa> getAllDatosMapasPorProvincia(Integer idMapa, String provincia)
	{
		List<DatosMapa> result = (List<DatosMapa>) datosMaparepository.findALLDatosLocalidadesByMapaAndProvincia(idMapa, provincia);
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DatosMapa>();
		}
	}
	
	/**
	 * Metodo que obtiene todos los datos de un mapa a partir del id del mapa.
	 * @param idMapa Un integer que contiene el id del mapa.
	 * @return Devuelve un arraylist con los datos del mapa.
	 */
	public List<DatosMapa> getAllDatosMapasPorMapa(Integer idMapa)
	{
		List<DatosMapa> result = (List<DatosMapa>) datosMaparepository.findALLDatosLocalidadesById_Mapa(idMapa);
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DatosMapa>();
		}
	}
	
	/**
	 * Metodo que devuelve el dato de mapa de un localidad determinada
	 * @param datosMapas Un arraylist que contiene todos los datos de un mapa
	 * @param id Un integer que contiene el id de la localidad.
	 * @return Un objeto de tipo DatosMapaTabla que contiene todos los datos del mapa de esa localidad.
	 * @throws RecordNotFoundException
	 */
	public DatosMapaTabla getById(ArrayList<DatosMapaTabla> datosMapas, Integer id) throws RecordNotFoundException 
	{
		DatosMapaTabla datosMapa = null;
		
		for (int i = 0; i < datosMapas.size(); i++) 
			{
				if (datosMapas.get(i).getId() == id) 
					{
					 	datosMapa = datosMapas.get(i);
					}
			}
		return datosMapa;
		
	}
	
	/**
	 * Metodo para actualizar los datos de un dato de un mapa.
	 * @param entity Un objeto de tipo DatosMapaTabla que contiene los datos del dato del mapa a actualizar.
	 * @param idLocalidad Un integer que contiene el id de la localidad.
	 */
	public void updateDatosMapa(DatosMapaTabla entity, Integer idLocalidad) {
			
			Optional<DatosMapa> datosMapa = datosMaparepository.findById(entity.getId());
			
			if(datosMapa.isPresent()) 
			{
			
				DatosMapa newEntity = datosMapa.get();
				newEntity.setId(entity.getId());
				newEntity.setIdMapa(entity.getMapa());
				newEntity.setIdLocalidad(idLocalidad);
				newEntity.setCasos(entity.getCasos());
			datosMaparepository.save(newEntity);
			}
		}
	
	/**
	 * Metodo para añadir un nuevo dato a un nuevo dato de un mapa
	 * @param datosmapa Un objeto de tipo DatosMapa con los nuevos datos.
	 */
	public void addNewdatosMapa(DatosMapa datosmapa) {
		datosMaparepository.save(datosmapa);
	}
		
	/**
	 * Metodo para borrar un dato de un mapa.
	 * @param id Un integer que contiene el id del dato de mapa a eliminar.
	 */
	public void deletedatosMapa(Integer id) {
		datosMaparepository.deleteById(id);
	}
}