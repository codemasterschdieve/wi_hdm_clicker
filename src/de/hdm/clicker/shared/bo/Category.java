package de.hdm.clicker.shared.bo;

/**
 * Das Objekt dieser Klasse stellt eine real existierende Kategorie dar.
 * Erbt von der Klasse BusinessObject und ist daher auch Serializable.
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */
public class Category extends BusinessObject {
	
	
	/**
	 * Membervariable für die Beschreibung
	 */
	private String description;
	
	/**
	 * Membervariable für die Identifikation des Lehrenden
	 */
	private int teacherid;

	/**
	 *  Beschreibung auslesen
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Beschreibung setzen
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Identifikationskennzeichnung des Lehrenden auslesen 
	 * @return teacherid
	 */
	public int getTeacherid() {
		return teacherid;
	}

	/**
	 *  Identifikationskennzeichnung des Lehrenden setzen
	 * @param teachid
	 */
	public void setTeacherid(int teachid) {
		this.teacherid = teachid;
	}
	
	
	
}