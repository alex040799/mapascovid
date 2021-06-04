package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Provincias;


/**
 * Repositorio que contiene las consultas query a realizar para obtener datos de las provincias.
 * @author Alejandro
 *
 */
@Repository
public interface provinciasRepository 
			extends CrudRepository<Provincias, String> {

	//Obtiene el dato de la provincia a partir de su nombre
	Optional<Provincias> findByNombre(String nombre);
}
