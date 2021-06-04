package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Localidades;
import com.example.demo.model.Mapas;
import com.example.demo.model.Provincias;
import com.example.demo.repository.provinciasRepository;

/**
 * Clase que contiene los metodos que obtienen los datos requeridos en el controller web de Provincias.
 * @author Alejandro
 *
 */

@Service
public class ProvinciasService {
	
	@Autowired
	provinciasRepository repository;
	
	/**
	 * Metodo que devuelve una lista con todas las provincias
	 * @return Un arraylist con todas las provincias.
	 */
	public List<Provincias> getAllProvincias()
	{
		List<Provincias> result = (List<Provincias>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Provincias>();
		}
	}
	
	/**
	 * Metodo que obtiene los datos de la provincia a partir de su nombre
	 * @param nombre Un string que contiene el nombre de la provincia
	 * @return Un objeto de tipo Provincias que contiene los datos de la provincia
	 * @throws RecordNotFoundException
	 */
	public Provincias getProvinciaByNombre(String nombre) throws RecordNotFoundException 
	{
		Optional<Provincias> provincia = repository.findByNombre(nombre);
		
		if(provincia.isPresent()) {
			return provincia.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	/**
	 * Metodo para actualizar los datos de la provincia
	 * @param entity Un objeto de tipo Provincias que contiene los datos de la provincia a actualizar.
	 */
	public void updateProvincia(Provincias entity) {
		
		Optional<Provincias> provincia = repository.findByNombre(entity.getNombre());
		
		if(provincia.isPresent()) 
		{
			Provincias newEntity = provincia.get();
			newEntity.setNombre(entity.getNombre());
			newEntity.setLatitud(entity.getLatitud());
			newEntity.setLongitud(entity.getLongitud());
			repository.save(newEntity);
		}
	}
	
	/**
	 * Metodo para añadir una nueva provincia
	 * @param provincia Un objeto de tipo Provincias que contiene los nuevos datos de la provincia.
	 */
	public void addNewProvincia(Provincias provincia) {
			repository.save(provincia);
	}
}