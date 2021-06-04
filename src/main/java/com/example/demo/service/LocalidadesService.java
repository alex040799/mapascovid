package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.DatosLocalidades;
import com.example.demo.model.Localidades;
import com.example.demo.repository.DatosMapaRepository;
import com.example.demo.repository.LocalidadesRepository;

/**
 * Clase que contiene los metodos que obtienen los datos requeridos en el controller web de Localidades.
 * @author Alejandro
 *
 */
@Service
public class LocalidadesService {
	
	@Autowired
	LocalidadesRepository repository;
	
	@Autowired
	DatosMapaRepository datosMapaRepository;
	
	/**
	 * Metodo que devuelve un arraylist con todas las localidades.
	 * @return Un arraylist con todas las localidades.
	 */
	public List<Localidades> getAllLocalidades()
	{
		List<Localidades> result = (List<Localidades>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Localidades>();
		}
	}
	
	/**
	 * Metodo para obtener un arraylist de las localidades de una provincia
	 * @param provincia Un string que contiene el nombre de la provincia
	 * @param mapa Un integer que contiene el id del mapa.
	 * @return Un arraylist que contiene las localidades.
	 * @throws RecordNotFoundException
	 */
	public List<Localidades> getByProvincia(String provincia, Integer mapa) throws RecordNotFoundException 
	{
		List<Localidades> result = (List<Localidades>) repository.findAllById(null);
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Localidades>();
		}
	}
	
	/**
	 * Metodo que devuelve el nombre de la localidad a partir de su id.
	 * @param id Un integer que contiene el id de la localidad.
	 * @return Un string con el nombre de la localidad.
	 */
	public String getNombreLocalidad(Integer id) 
	{
		String nombreLocalidad = repository.findNombreLocalidad(id);
		
		return nombreLocalidad;
	}
	
	/**
	 * Metodo que devuelve los datos de una localidad a partir de su id
	 * @param id Un integer que contiene el id de la localidad.
	 * @return Un objeto de tipo Localidad que contiene sus datos.
	 * @throws RecordNotFoundException
	 */
	public Optional<Localidades> getById(Integer id) throws RecordNotFoundException 
	{
		Optional<Localidades> localidad = repository.findById(id);
		if(localidad.isPresent()) {
			return localidad;
		} else {
			throw new RecordNotFoundException("No payment record exist for given id");
		}
	}
	
	/**
	 * Metodo que devuelve todas las localidad de una provincia y un mapa.
	 * @param provincia Un string que contiene el nombre de la provincia
	 * @param mapa Un integer que contiene el id del mapa.
	 * @return Un arraylist con los datos de las localidades
	 */
	public List<DatosLocalidades> getAllLocalidadesByProvinciaAndMapa(String provincia, Integer mapa)
		{
			List<DatosLocalidades> result = (List<DatosLocalidades>)  repository.findAllDatosLocalidades(provincia,mapa);
			if(result.size() > 0) {
				return result;
			} else {
				return new ArrayList<DatosLocalidades>();
			}
		}
		
	/**
	 * Metodo para actualizar los datos de una localidad.
	 * @param entity Un objeto Localidades que contiene los datos de la localidad.
	 */
	public void updateLocalidad(Localidades entity) {
		
		Optional<Localidades> localidad = repository.findById(entity.getId());
		
		if(localidad.isPresent()) 
		{
			Localidades newEntity = localidad.get();
			newEntity.setId(entity.getId());
			newEntity.setNombre(entity.getNombre());
			newEntity.setPoblacion(entity.getPoblacion());
			newEntity.setLatitud(localidad.get().getLatitud());
			newEntity.setLongitud(localidad.get().getLongitud());
			newEntity.setProvincia(entity.getProvincia());
			System.out.print("Hola"+ newEntity.getLatitud());
		repository.save(newEntity);
		}
	}

	/**
	 * Metodo que obtiene el id de la localidad a partir de su nombre
	 * @param localidad Un string con el nombre de la localidad
	 * @return Un integer que contiene el id de la localidad.
	 */
	public Integer getIdByNombre(String localidad) {
		 Integer idLocalidad = repository.findByNombre(localidad);
		 return idLocalidad;
	}
}