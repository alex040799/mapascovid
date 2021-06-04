package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DatosLocalidades;
import com.example.demo.model.DatosMapa;

/**
 * Consultas query para obtener datos de los mapas.
 * @author Alejandro
 *
 */
@Repository
public interface DatosMapaRepository 
			extends CrudRepository<DatosMapa, Integer> {

	//Obtiene los datos de las localidades a partir del id del mapa
	@Query(value = "SELECT * FROM datosmapa d WHERE d.id_Mapa = :idMapa", nativeQuery = true)
	List <DatosMapa> findALLDatosLocalidadesById_Mapa(@Param("idMapa") Integer idMapa);
	
	//Obtiene los datos del mapa a partir del mapa y la provincia.
	@Query(value = "SELECT * FROM datosmapa d inner join localidades l on l.id = d.id_Localidad WHERE d.id_Mapa = :idMapa and l.provincia = :provincia" , nativeQuery = true)
	List <DatosMapa> findALLDatosLocalidadesByMapaAndProvincia(@Param("idMapa") Integer idMapa, @Param("provincia") String provincia);

}
