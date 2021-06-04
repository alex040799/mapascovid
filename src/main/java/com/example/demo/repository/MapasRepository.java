package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Mapas;

/**
 * Repositorio que contiene las consultas query a realizar para obtener datos de los mapas.
 * @author Alejandro
 *
 */

@Transactional
@Repository
public interface MapasRepository 
			extends CrudRepository<Mapas, Integer> {
	
	//Metodo que obtiene el tipo de mapa a partir de su id.
	@Query(value = "SELECT m.tipo FROM mapas m WHERE m.id = :id", nativeQuery = true)
	String findTipoMapasById(@Param("id")Integer id);
}
