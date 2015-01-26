package de.hdm.clicker.shared.bo;

/**
 * Das Objekt dieser Klasse stellt eine real existierende Infografik dar. Diese Grafik wird aus dem Datenbereich der Ergebnisse abgeleitet.
 * Erbt von der Klasse BusinessObject und ist daher auch Serializable.
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */

public class InfoGraph extends BusinessObject {
	
	/**
	 * Membervariable für den Fragentext
	 */
	private String questiontext = null;
	
	/**
	 * Membervariable für die Anzahl der falschen Antworten
	 */
	private int wronganswers;
	
	/**
	 * Membervariable für die Anzahl der richtigen Antworten
	 */
	private int correctanswers;

	/**
	 *Fragentext auslesen
	 * @return questiontext
	 */
	public String getQuestionText() {
		return questiontext;
	}

	/**
	 * Fragentext setzen
	 * @param questiontext
	 */
	public void setQuestionText(String questiontext) {
		this.questiontext = questiontext;
	}

	/**
	 * Anzahl der falschen Antworten auslesen
	 * @return wronganswers
	 */
	public int getWrongAnswers() {
		return wronganswers;
	}

	/**
	 * Anzahl der falschen Antworten setzen
	 * @param numberwronganswers
	 */
	public void setWrongAnswers(int numberwronganswers) {
		this.wronganswers = numberwronganswers;
	}

	/**
	 * Anzahl der richtigen Antworten setzen
	 * @return correctanswers
	 */
	public int getCorrectAnswers() {
		return correctanswers;
	}

	/**
	 * Anzahl der richtigen Antworten auslesen
	 * @param numbercorrectanswers
	 */
	public void setCorrectAnswers(int numbercorrectanswers) {
		this.correctanswers = numbercorrectanswers;
	}
	
	
	
}