package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase define los objetos de Mapas
 * @author Alejandro
 *
 */

@Entity
@Table(name="mapas")
public class Mapas {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Integer id;
	    
	    @Column(name="nombre")
	    private String nombre;
	    
	    @Column(name="tipo")
	    private String tipo;

	    /**
	     * Metodo que contiene el id del mapa
	     * @return Un integer con el id del mapa
	     */
		public Integer getId() {
			return id;
		}

		/**
		 * Establece el id del mapa
		 * @param id Un integer que contiene el id del mapa
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * Metodo que estable el nombre del mapa
		 * @return Un string que contiene el nombre del mapa
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * Establece el nombre del mapa
		 * @param nombre Un string que contiene el nombre del mapa
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * Metodo que obtiene el tipo de mapa
		 * @return Un string que contiene el tipo de mapa
		 */
		public String getTipo() {
			return tipo;
		}

		/**
		 * Metodo que establece el tipo de mapa
		 * @param tipo Un string que contiene el tipo de mapa
		 */
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
}
