package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase define los objetos de DatosMapa
 * @author Alejandro
 *
 */

@Entity
@Table(name="datosmapa")
public class DatosMapa {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
	    private Integer id;
	    
	    @Column(name="id_Mapa")
	    private Integer idMapa;
	    
	    @Column(name="id_Localidad")
	    private Integer idLocalidad;
	    
	    @Column(name="casos")
	    private Integer casos;

	    /**
	     * Metodo que obtiene el id del dato de mapa
	     * @return Devuelve un integer que contiene el id del mapa
	     */
		public Integer getId() {
			return id;
		}

		/**
		 * Metodo que establece el id del dato del mapa
		 * @param id Un integer que contiene el dato del mapa
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * Metodo que obtiene el id del mapa
		 * @return Devuelve un integer que contiene el id del mapa
		 */
		public Integer getIdMapa() {
			return idMapa;
		}

		/**
		 * Establece el id del mapa
		 * @param idMapa Un integer que contiene el id del mapa
		 */
		public void setIdMapa(Integer idMapa) {
			this.idMapa = idMapa;
		}

		/**
		 * Obtiene el id de la localidad
		 * @return Un integer que contiene el id de la localidad
		 */
		public Integer getIdLocalidad() {
			return idLocalidad;
		}

		/**
		 * Metodo que establece el id de la localidad
		 * @param idLocalidad Un integer que contiene el id de la localidad
		 */
		public void setIdLocalidad(Integer idLocalidad) {
			this.idLocalidad = idLocalidad;
		}

		/**
		 * Metodo que obtiene los casos covid-19
		 * @return Un integer que contiene los casos covid-19
		 */
		public Integer getCasos() {
			return casos;
		}

		/**
		 * Metodo que establece los casos covid-19
		 * @param casos Un integer que contiene los casos de covid-19
		 */
		public void setCasos(Integer casos) {
			this.casos = casos;
		}
	    	    
}
