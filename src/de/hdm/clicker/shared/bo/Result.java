package de.hdm.clicker.shared.bo;

/**
 * Das Objekt dieser Klasse stellt ein real existierendes  dar.
 * Erbt von der Klasse BusinessObject und ist daher auch Serializable. 
 * 
 * @author Moser, Sonntag
 * @version 1.0
 */

public class Result extends BusinessObject {
	
	private String hdmUser;
	
	private int questionID;
	
	private int quizID;
	
	private int quizVersion;
	
	private int answerNo;
	
	private boolean answered;
	
	private boolean successed;

	public String getHdmUser() {
		return hdmUser;
	}

	public void setHdmUser(String hdmUser) {
		this.hdmUser = hdmUser;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getQuizID() {
		return quizID;
	}

	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public int getQuizVersion() {
		return quizVersion;
	}

	public void setQuizVersion(int quizVersion) {
		this.quizVersion = quizVersion;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

	public boolean isSuccessed() {
		return successed;
	}

	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}
	
	
}