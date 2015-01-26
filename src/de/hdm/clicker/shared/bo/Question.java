package de.hdm.clicker.shared.bo;

/**
 * Das Objekt dieser Klasse stellt eine real existierende Frage dar.
 * Erbt von der Klasse BusinessObject und ist daher auch Serializable.
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */

public class Question extends BusinessObject {
	
	/**
	 * Membervariable für Fragentext
	 */
	private String questiontext;
	
	/**
	 * Membervariable für Antworttext1
	 */
	private String answer1text;
	
	/**
	 *Membervariable für Antworttext2
	 */
	private String answer2text;
	
	/**
	 * Membervariable für Antworttext3
	 */
	private String answer3text;
	
	/**
	 * Membervariable für Antworttext4
	 */
	private String answer4text;
	
	/**
	 * Membervariable für Nummer der richtigen Antwort
	 */
	private int numberofrightanswer;
	
	/**
	 * Membervariable für die Schwierigkeit
	 */
	private int difficulty;
	
	/**
	 * Membervariable für das Bild
	 */
	private boolean image;
	
	/**
	 * Membervariable für den Status der Frage
	 */
	private boolean active;
	
	/**
	 * Membervariable für die Kategorie Id
	 */
	private int categoryid;

	/**
	 * Kategorie Id auslesen
	 * @return categoryid
	 */
	public int getCategorieId() {
		return categoryid;
	}

	/**
	 * Kategorie Id setzen
	 * @param categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryid = categoryId;
	}

	/**
	 * Fragetext auslesen
	 * @return questiontext
	 */
	public String getQuestionText() {
		return questiontext;
	}

	/**
	 * Fragetext setzen
	 * @param questiontext
	 */
	public void setQuestionText(String questiontext) {
		this.questiontext = questiontext;
	}

	/**
	 * Antworttext1 auslesen
	 * @return answer1text
	 */
	public String getAnswer1Text() {
		return answer1text;
	}

	/**
	 * Antworttext1 setzen
	 * @param answer1
	 */
	public void setAnswer1Text(String answer1) {
		this.answer1text = answer1;
	}

	/**
	 * Antworttext2 auslesen
	 * @return
	 */
	public String getAnswer2Text() {
		return answer2text;
	}

	/**
	 * Antworttext2 setzen
	 * @param answer2
	 */
	public void setAnswer2Text(String answer2) {
		this.answer2text = answer2;
	}

	/**
	 * Antworttext3 auslesen
	 * @return
	 */
	public String getAnswer3Text() {
		return answer3text;
	}

	/**
	 * Antworttext3 setzen
	 * @param answer3
	 */
	public void setAnswer3Text(String answer3) {
		this.answer3text = answer3;
	}

	/**
	 * Antworttext4 auslesen
	 * @return
	 */
	public String getAnswer4Text() {
		return answer4text;
	}

	/**
	 * Antworttext4 setzen
	 * @param answer4
	 */
	public void setAnswer4Text(String answer4) {
		this.answer4text = answer4;
	}

	/**
	 * Position der richtigen Antwort auslesen
	 * @return
	 */
	public int getPositionofRightAnswer() {
		return numberofrightanswer;
	}

	/**
	 * Position der richtigen Antwort setzen
	 * @param numberofcorrectanswer
	 */
	public void setPositionofRightAnswer(int numberofcorrectanswer) {
		this.numberofrightanswer = numberofcorrectanswer;
	}

	/**
	 * Schwierigkeit auslesen
	 * @return
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Schwierigkeit setzen
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Status der Frage auslesen
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Status der Frage setzen
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Bild auslesen
	 * @return
	 */
	public boolean isImage() {
		return image;
	}

	/**
	 * Bild setzen
	 * @param image
	 */
	public void setImage(boolean image) {
		this.image = image;
	}
	
	

}