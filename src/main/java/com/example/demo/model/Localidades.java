package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Esta clase define los objetos de Localidades
 * @author Alejandro
 *
 */

@Entity
@Table(name="localidades")
public class Localidades {

			    @Id
			    @GeneratedValue(strategy = GenerationType.IDENTITY)
			    @Column(name="id")
			    private Integer id;
			    
			    @Column(name="nombre")
			    private String nombre;
			    
			    @Column(name="poblacion")
			    private Integer poblacion;
			    
			    @Column(name="latitud")
			    private Float latitud;
			    
			    @Column(name="longitud")
			    private Float longitud;
			    			    
			    @Column(name="limites")
			    private String limites;
			    
			    @Column(name="provincia")
			    private String provincia;
			    
			    /**
			     * Metodo que obtiene el id de la localidad
			     * @return Un integer que contiene el id de la localidad
			     */
				public Integer getId() {
					return id;
				}

				/**
				 * Metodo que establece el id de la localidad
				 * @param id Un integer que contiene el id de la localidad
				 */
				public void setId(Integer id) {
					this.id = id;
				}

				/**
				 * Metodo que devuelve el nombre de la localidad
				 * @return Un string con el nombre de la localidad
				 */
				public String getNombre() {
					return nombre;
				}

				/**
				 * Metodo que establece el nombre de la localidad
				 * @param nombre Un string que contiene el nombre de la localidad
				 */
				public void setNombre(String nombre) {
					this.nombre = nombre;
				}

				/**
				 * Metodo que devuelve la poblacion de la localidad
				 * @return Devuelve un integer con la poblacion de la localidad
				 */
				public Integer getPoblacion() {
					return poblacion;
				}

				/**
				 * Metodo que establece la poblacion de la localidad
				 * @param poblacion Un integer que contiene la poblacion de la localidad
				 */
				public void setPoblacion(Integer poblacion) {
					this.poblacion = poblacion;
				}

				/**
				 * Metodo que obtiene la latitud de la localidad
				 * @return Un Float que contiene la latitud de la localidad
				 */
				public Float getLatitud() {
					return latitud;
				}

				/**
				 * Metodo que establece la latitud de la localidad
				 * @param latitud Un Float que contiene la latitud de la localidad
				 */
				public void setLatitud(Float latitud) {
					this.latitud = latitud;
				}

				/**
				 * Metodo que obtiene la longitud de la localidad
				 * @return Devuelve un Float que contiene la longitud de la localidad
				 */
				public Float getLongitud() {
					return longitud;
				}

				/**
				 * Metodo que establece la longitud de la localidad
				 * @param longitud Un float con la longitud de la localidad
				 */
				public void setLongitud(Float longitud) {
					this.longitud = longitud;
				}

				/**
				 * Metodo que obtiene los limites de la localidad
				 * @return Un string que contiene los limites de la localidad
				 */
				public String getLimites() {
					return limites;
				}

				/**
				 * Establece los limites de la localidad
				 * @param limites Un string que contiene los limites de la localidad
				 */
				public void setLimites(String limites) {
					this.limites = limites;
				}

				/**
				 * Metodo que obtiene la provincia
				 * @return Un string que contiene la provincia de la localidad
				 */
				public String getProvincia() {
					return provincia;
				}

				/**
				 * Establece la provincia de la localidad
				 * @param provincia Un string que contiene el nombre de la provincia
				 */
				public void setProvincia(String provincia) {
					this.provincia = provincia;
				}
				
}
				
