package de.hdm.clicker.shared.bo;

import java.io.Serializable;

/**
 * 
 * <p>
 * Diese Klasse <code>BusinessObject</code> ist repräsentativ für die objektorientierte Umsetzung der Applikation. 
 * Sie stellt die Superklasse sämtlicher BusinessObjekte dar, die in dem package bo zusammengefasst werden. 
 * Hierbei handelt es sich um die abstrakte Repräsentation real existierender Entitäten. Näher betrachtet handelt es sich hierbei um die Klassen
 * Category,Teacher, Question, Quiz und Result. Das gemeinsame Attribut jedes <code>BusinessObject</object> ist ein eindeutiger Primärschlüssel, die sogenannte id.
 * Zudem ist jedes <code>BusinessObject</code> mit dem Interface Serializable markiert. Dadurch können die <code>BusinessObject</code> zwischen Client und Server übertragen werden.
 * </p>
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */

public abstract class BusinessObject implements Serializable {

	/**
	 * Statische id die für die Serializierung notwendig ist
	 */
	private static final long serialVersionUID = 1L;	
	
	/**
	   * Eindeutige und einzigartige Identifikationskennzeichnung des BusinessObjects
	   */
	private int id;	
	
	/**
	   * id auslesen
	   * @return id
	   */
	public int getId() {
		return id;
	}

	/**
	   * id setzen
	   * @param id
	   */
	public void setId(int id) {
		this.id = id;
	}
 
}