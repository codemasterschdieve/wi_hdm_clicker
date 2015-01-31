package de.hdm.clicker.shared.bo;

public class User extends BusinessObject {
	
	
	/**
	 *  Membervariable für den Username
	 */
	private String username;
	
	/**
	 * Membervariable für den Vornamen
	 */
	private String firstname;
	
	/**
	 * Membervariable für den Nachnamen
	 */
	private String lastname;
	
	/**
	 * Membervariable für das Passwort
	 */
	private String password;
	
	/**
	 * Username auslesen
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Username setzen
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Vorname auslesen
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Vorname setzen
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Nachname auslesen
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Nachname setzen
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

}
