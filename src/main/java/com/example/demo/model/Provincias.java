package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase define los objetos de Provincias
 * @author Alejandro
 *
 */

@Entity
@Table(name="provincia")
public class Provincias {

	  	@Id
	    @Column(name="nombre")
	    private String nombre;
	  	
	    @Column(name="latitud")
	    private Float latitud;
	    
	    @Column(name="longitud")
	    private Float longitud;

	    /**
	     * Metodo que obtiene el nombre de la provincia
	     * @return Un string con el nombre de la provincia
	     */
		public String getNombre() {
			return nombre;
		}

		/**
		 * Establece el nombre de la provincia
		 * @param nombre Un string que contiene el nombre de la provincia
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * Metodo que obtiene la latitud de la provincia
		 * @return Un Float que contiene la latitud de la provincia
		 */
		public Float getLatitud() {
			return latitud;
		}

		/**
		 * Metodo que establece la latitud de la provincia
		 * @param latitud Un float que contiene la latitud de la provincia
		 */
		public void setLatitud(Float latitud) {
			this.latitud = latitud;
		}

		/**
		 * Metodo que obtiene la longitud de la provincia
		 * @return Un Float que contiene la longitud de la provincia
		 */
		public Float getLongitud() {
			return longitud;
		}

		/**
		 * Establece la longitud de la provincia
		 * @param longitud Un Float con la longitud de la provincia
		 */
		public void setLongitud(Float longitud) {
			this.longitud = longitud;
		}
		
	    
}
