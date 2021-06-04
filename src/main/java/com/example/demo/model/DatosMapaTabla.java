package com.example.demo.model;

/**
 * Esta clase define los objetos de DatosMapaTabla a mostrar en la tabla de datos de un mapa
 * @author Alejandro
 *
 */
public class DatosMapaTabla {

	public Integer id;
	public Integer mapa;
	public String localidad;
	public Integer casos;
		
	/**
	 * Constructor por defecto de DatosMapaTabla
	 */
	public DatosMapaTabla() {
		
	}
		
	/**
	 * Constructor para crear un objeto DatosMapaTabla
	 * @param id
	 * @param mapa
	 * @param localidad
	 * @param casos
	 */
	public DatosMapaTabla(Integer id, Integer mapa, String localidad, Integer casos) {
		this.id = id;
		this.mapa = mapa;
		this.localidad = localidad;
		this.casos = casos;		
	}

	/**
	 * Metodo para obtener el id del dato del mapa
	 * @return Un integer que contiene el id del dato de mapa
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Metodo que establece el id del dato de mapa
	 * @param id Un integer que contiene el id del dato de mapa
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Metodo que obtiene el id del mapa
	 * @return Un integer que contiene el id del mapa
	 */
	public Integer getMapa() {
		return mapa;
	}

	/**
	 * Metodo para establecer el id del mapa
	 * @param mapa Un integer que contiene el id del mapa
	 */
	public void setMapa(Integer mapa) {
		this.mapa = mapa;
	}

	/**
	 * Metodo para obtener el nombre de la localidad
	 * @return Un string que contiene el nombre de la localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Metodo que establece el nombre de la localidad
	 * @param localidad Un string que contiene el nombre de la localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * Metodo que obtiene los casos de covid-19
	 * @return Un integer con los casos de covid-19
	 */
	public Integer getCasos() {
		return casos;
	}

	/**
	 * Metodo que establece los casos de covid-19
	 * @param casos Un integer que contiene los casos de covid-19
	 */
	public void setCasos(Integer casos) {
		this.casos = casos;
	}
	
}
