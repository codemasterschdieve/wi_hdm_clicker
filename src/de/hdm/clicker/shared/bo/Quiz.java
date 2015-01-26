package de.hdm.clicker.shared.bo;

import java.sql.Time;
import java.util.Date;

/**
 * Das Objekt dieser Klasse stellt ein real existierendes Quiz dar.
 * Erbt von der Klasse BusinessObject und ist daher auch Serializable.
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */

public class Quiz extends BusinessObject {

	/**
	 * Membervariable für die Version des Quiz
	 */
	private int version = 0;
	
	/**
	 * Membervariable für den Startdatum
	 */
	private int startingDate;
	
	/**
	 * Membervariable für den Startzeitpunkt
	 */
	private int startingTime;
	
	/**
	 * Membervariable für das Passwort
	 */
	private String password;
	
	/**
	 * Membervariable für den Dauerknopf
	 */
	private int durationButton;
	
	/**
	 * Membervariable Beschreibung
	 */
	private String description;
	
	/**
	 * Membervariable für die teacher Id
	 */
	private int teacherid;
	
	/**
	 * Membervariable für die Dauer der Frage
	 */
	private int durationQuestion;

	/**
	 * Membervariable für den Status des Quiz
	 */
	private boolean active;
	
	/**
	 * Membervariable
	 */
	private boolean automatic;
	
	/**
	 * Membervariable für zufälliges Anordnen der Fragen
	 */
	private boolean randomorder;
	
	/**
	 * Membervariable die an gibt ob das Quiz schon begonnen hat
	 */
	private boolean started;
	
	/**
	 * Membervariable
	 */
	private int questionsCount;
	
	/**
 	* Auslesen ob das Quiz schon begonnen hat
 	* @return
 	*/
	public boolean isStarted() {
		return started;
	}

	/**
	 * Setzen ob das Quiz schon begonnen hat
	 * @param started
	 */
	public void setStarted(boolean started) {
		this.started = started;
	}

	/**
	 * Version auslesen
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Version setzen
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Startdatum auslesen
	 * @return
	 */
	public int getStartingDate() {
		return startingDate;
	}

	/**
	 * Startdatum setzen
	 * @param startingdate
	 */
	public void setStartingDate(int startingdate) {
		this.startingDate = startingdate;
	}

	/**
	 * Startzeitpunkt auslesen
	 * @return
	 */
	public int getStartingTime() {
		return startingTime;
	}

	/**
	 * Startzeitpunkt setzen
	 * @param startingtime
	 */
	public void setStartingTime(int startingtime) {
		this.startingTime = startingtime;
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
	 * 
	 * @return
	 */
	public int getDurationButton() {
		return durationButton;
	}

	/**
	 * 
	 * @param durationButton
	 */
	public void setDurationButton(int durationButton) {
		this.durationButton = durationButton;
	}

	/**
	 * Beschreibung auslesen
	 * @return
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
	 * Teacher Id auslesen
	 * @return
	 */
	public int getTeacherId() {
		return teacherid;
	}

	/**
	 * Teacher Id setzen
	 * @param teacherid
	 */
	public void setTeacherId(int teacherid) {
		this.teacherid = teacherid;
	}

/**
 * 
 * @return
 */
	public int getDurationQuestion() {
		return durationQuestion;
	}
	
/**
 * 
 * @param durationQuestion
 */
	public void setDurationQuestion(int durationQuestion) {
		this.durationQuestion = durationQuestion;
	}

/**
 * Status auslesen
 * @return
 */
	public boolean isActive() {
		return active;
	}
/**
 * Status setzen
 * @param active
 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 * 
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

/**
 * Auslesen ob zufällige Reihenfolge gesetzt ist
 * @return
 */
	public boolean isRandomOrder() {
		return randomorder;
	}

	/**
	 * Zufällige Reihenfolge setzen
	 * @param random
	 */
	public void setRandomOrder(boolean random) {
		this.randomorder = random;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuestionsCount() {
		return questionsCount;
	}

	/**
	 * 
	 * @param questionsCount
	 */
	public void setQuestionsCount(int questionsCount) {
		this.questionsCount = questionsCount;
	}
	
	
	
}