package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DatosLocalidades;
import com.example.demo.model.Localidades;

/**
 * Repositorio que contiene las consultas query a realizar para obtener datos de localidades.
 * @author Alejandro
 *
 */
@Repository
public interface LocalidadesRepository 
			extends CrudRepository<Localidades, Integer> {
	
	//Metodo para obtener los datos de las localidades.
	@Query("SELECT new com.example.demo.model.DatosLocalidades(l.nombre as nombre ,l.poblacion as poblacion, l.latitud as latitud, l.longitud as longitud, l.limites as limites, d.casos as casos) from Localidades l, DatosMapa d WHERE l.id = d.idLocalidad and l.provincia = :provincia and d.idMapa= :mapa")
	List<DatosLocalidades> findAllDatosLocalidades(@Param("provincia") String provincia, @Param("mapa") Integer idMapa);
	
	//Metodo para obtener el nombre de la localidad
	@Query(value = "SELECT l.nombre FROM localidades l WHERE l.id = :id", nativeQuery = true)
	String findNombreLocalidad(@Param("id")Integer id);

	//Metodo para obtener el id de la localidad a partir de su nombre.
	@Query(value = "SELECT l.id FROM localidades l WHERE l.nombre = :nombre", nativeQuery = true)
	Integer findByNombre(@Param("nombre")String nombre);
}
