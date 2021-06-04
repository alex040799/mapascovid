package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Mapas;
import com.example.demo.repository.DatosMapaRepository;
import com.example.demo.repository.MapasRepository;

/**
 * Clase que contiene los metodos que obtienen los datos requeridos en el controller web de Mapas.
 * @author Alejandro
 *
 */

@Service
public class MapasService {
	
	@Autowired
	MapasRepository repository;
	
	@Autowired
	DatosMapaRepository datosMaparepository;
	
	/**
	 * Metodo que devuelve todos los mapas.
	 * @return Un arraylist con todos los mapas.
	 */
	public List<Mapas> getAllMapas()
	{
		List<Mapas> result = (List<Mapas>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Mapas>();
		}
	}
	
	/**
	 * Metodo que devuelve el tipo de mapa a partir del id del mapa.
	 * @param id Un integer que contiene el id del mapa.
	 * @return Un string que contiene el tipo de mapa.
	 */
	public String getTipoMapa(Integer id) 
	{

		String tipo = repository.findTipoMapasById(id);
		return tipo;
	}
	
	/**
	 * Metodo que obtiene los datos de un mapa a partir de su id
	 * @param id Un integer que contiene el id del mapa
	 * @return Un objeto de itpo Mapas con los datos del mapa.
	 * @throws RecordNotFoundException
	 */
	public Optional<Mapas> getById(Integer id) throws RecordNotFoundException 
	{
		Optional<Mapas> mapa = repository.findById(id);
		if(mapa.isPresent()) {
			return mapa;
		} else {
			throw new RecordNotFoundException("No payment record exist for given id");
		}
	}
	
	/**
	 * Metodo para añadir un nuevo mapa.
	 * @param mapa Un objeto de tipo Mapas que contiene los datos del nuevo mapa.
	 */
	public void addNewMapa(Mapas mapa) {
			repository.save(mapa);
	}
	
	/**
	 * Metodo para actualizar los datos de un mapa
	 * @param entity Un objeto de tipo Mapas que contiene los datos del mapa a actualizar.
	 */
	public void updateMapa(Mapas entity) {
		
		Optional<Mapas> mapa = repository.findById(entity.getId());
		
		if(mapa.isPresent()) 
		{
			Mapas newEntity = mapa.get();
			newEntity.setId(entity.getId());
			newEntity.setNombre(entity.getNombre());
			newEntity.setTipo(entity.getTipo());
			repository.save(newEntity);
		}
	}
	
	/**
	 * Metodo para borrar un mapa a partir de su id
	 * @param id Un integer que contiene el id del mapa
	 */
	public void deleteMapa(Integer id) {
		
		repository.deleteById(id);
	}
	
}