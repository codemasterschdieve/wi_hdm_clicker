package de.hdm.clicker.shared.bo;

/**
 * Das Objekt dieser Klasse stellt einen real existierenden Lehrenden dar.
 * Erbt von der Klasse BusinessObject und ist daher auch Serializable.
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */

public class Teacher extends BusinessObject {

	/**
	 * Membervariable für den Username
	 */
	private String user;
	
	/**
	 * Membervariable für das Passwort
	 */
	private String password;
	
	/**
	 * Membervariable für den Vornamen
	 */
	private String firstname;
	
	/**
	 * Membervariable für den Nachnamen
	 */
	private String lastname;

	/**
	 * Username auslesen
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Username setzen
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Passwort auslesen
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Passwort setzen
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Vornamen auslesen
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Vornamen setzen
	 * @param firstName
	 */
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	/**
	 * Nachnamen auslesen
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Nachnamen setzen
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}