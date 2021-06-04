package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Esta clase define los objetos de datos localidades
 * @author Alejandro
 *
 */
public class DatosLocalidades {

	public String nombre;
	public Integer poblacion;
	public Float latitud;
	public Float longitud;
	public String limites;
	public Integer casos;
	
	/**
	 * Constructor por defecto
	 */
	public DatosLocalidades() {
		
	}
	
	/**
	 * Constructor para crear un objeto DatosLocalidades
	 * @param nombre 	Nombre de la poblacion
	 * @param poblacion	Numero de habitantes de la poblacion
	 * @param latitud 	Latitud de la poblacion
	 * @param longitud	Longitud de la poblacion
	 * @param limites	Limites perimetrales de la poblacion
	 * @param casos		Numero de casos semanales de covid-19 en la localidad
	 */
	
	public DatosLocalidades(String nombre, Integer poblacion, Float latitud, Float longitud, String limites, Integer casos) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.limites = limites;
		this.casos = casos;
	}
	
	/**
	 * Obtiene el nombre de la localidad
	 * @return Un string que contiene el nombre de la localidad
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre de la localidad
	 * @param nombre Un string que contiene el nombre de la localidad
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene el numero de habitantes de la localidad
	 * @return	Un integer que contiene el numero de habitantes de la localidad
	 */
	public Integer getPoblacion() {
		return poblacion;
	}
	
	/**
	 * Establece el numero de habitantes de la localidad
	 * @param poblacion Un integer que contiene el número de habitantes de la localidad
	 */
	public void setPoblacion(Integer poblacion) {
		this.poblacion = poblacion;
	}
	
	/**
	 * Obtiene la latitud de la localidad
	 * @return Un float que contiene la latitud de la localidad
	 */
	public Float getLatitud() {
		return latitud;
	}
	
	/**
	 * Establece la latitud de la localidad
	 * @param latitud Un float para establecer la latitud de la localidad
	 */
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	
	/**
	 * Obtiene la longitud de la localidad
	 * @return Un float que contiene la longitud de la localidad
	 */
	public Float getLongitud() {
		return longitud;
	}
	
	/**
	 * Establece la longitud de la localidad
	 * @param longitud Un float que contiene la longitud de la localidad
	 */
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	
	/**
	 * Obtiene los limites perimetrales de la localidad
	 * @return Un string que contiene los limites perimetrales de la localidad
	 */
	public String getLimites() {
		return limites;
	}

	/**
	 * Establece los límites perimetrales de la localidad
	 * @param limites Un String que contiene los limites perimetrales de la localidad
	 */
	public void setLimites(String limites) {
		this.limites = limites;
	}

	/**
	 * Devuelve un integer que contiene los casos de la localidad
	 * @return Un integer que contiene los casos de la localidad
	 */
	public Integer getCasos() {
		return casos;
	}
	
	/**
	 * Establece los casos de la localidad
	 * @param casos Un integer que contiene los casos de la localidad
	 */
	public void setCasos(Integer casos) {
		this.casos = casos;
	}
	
	
}
