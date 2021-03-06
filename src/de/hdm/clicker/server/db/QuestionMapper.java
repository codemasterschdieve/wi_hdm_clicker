package de.hdm.clicker.server.db;


import java.sql.*;
import java.util.Vector;

import de.hdm.clicker.shared.bo.*;

/**
 * Mapper-Klasse, die <code>Question</code>-Objekte auf eine relationale
 * Datenbank abbildet. Hierzu wird eine Reihe von Methoden zur Verfügung
 * gestellt, mit deren Hilfe z.B. Objekte gesucht, erzeugt, modifiziert und
 * gelöscht werden können. Das Mapping ist bidirektional. D.h., Objekte können
 * in DB-Strukturen und DB-Strukturen in Objekte umgewandelt werden.
 * 
 * @see CategoryMapper
 * @see TeacherMapper
 * @see QuestionMapper
 * @see ResultsMapper
 * 
 * @author Zimmermann, Roth, Zanella
 * @version 1.0
 */
public class QuestionMapper {
	
	/**
	 * Die Klasse LecturerMapper wird nur einmal instantiiert. Man spricht hierbei
	 * von einem sogenannten <b>Singleton</b>.
	 * <p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal für
	 * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static QuestionMapper QuestionMapper = null;
	
	/**
	 * Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
	 * Instanzen dieser Klasse zu erzeugen.
	 * 
	 */
	protected QuestionMapper(){
		
	}
	
	/**
	 * Diese statische Methode kann aufgrufen werden durch
	 * <code>QuestionMapper.questionMapper()</code>. Sie stellt die
	 * Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine einzige
	 * Instanz von <code>QuestionMapper</code> existiert.
	 * <p>
	 * 
	 * <b>Fazit:</b> QuestionMapper sollte nicht mittels <code>new</code>
	 * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 * 
	 * @return DAS <code>QuestionMapper</code>-Objekt.
	 */
	public static QuestionMapper questionMapper() {
	    if (QuestionMapper == null) {
	    	QuestionMapper = new QuestionMapper();
	    }

	    return QuestionMapper;
	   }
	
	/**
	 * Methode um eine beliebige Anzahl an Questions anhand Ihrerer ID's aus der
	 * DB auszulesen
	 * 
	 * @param	keys - Primärschlüsselattribut(e) (->DB)
	 * @return	Vector mit Questions, die den Primärschlüsselattributen entsprechen
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Vector<Question> findByKey(Vector<Integer> keys) throws RuntimeException {
		StringBuffer ids = new StringBuffer();
		
		//Erstellung des dynamischen Teils des SQL-Querys	
		if (keys.size() > 1) {
			for (int i = 0; i < keys.size()-1; i++) {
			ids.append(keys.elementAt(i));	
			ids.append(",");
			}		
		}
			
		ids.append(keys.elementAt(keys.size()-1));			
			
		//Einholen einer DB-Verbindung		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		ResultSet rs;
		Vector<Question> questions = new Vector<Question>();
		try{
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Question WHERE id IN (" + ids.toString() + ") ORDER BY questionbody";
			rs = stmt.executeQuery(sql);
			
			// Erstellung des "Question-Vectors"
			while(rs.next()){
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestionText(rs.getString("questionbody"));
				if (rs.getInt("image") == 1) {
					question.setImage(true);
				} else {
					question.setImage(false);
				}
				question.setPositionofRightAnswer(rs.getInt("correctAnswer"));
				question.setDifficulty(rs.getInt("severity"));
				question.setAnswer1Text(rs.getString("Answer_1"));
				question.setAnswer2Text(rs.getString("Answer_2"));
				question.setAnswer3Text(rs.getString("Answer_3"));
				question.setAnswer4Text(rs.getString("Answer_4"));
				if (rs.getInt("Active") == 1) {
					question.setActive(true);
				} else {
					question.setActive(false);
				}
				question.setCategoryId(rs.getInt("categoryid"));
				questions.add(question);
			}
						
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm fbk: " + e1.getMessage());				
		}
		
		db.closeConnection();
		return questions;
	}
	
	/**
	 * Methode um eine beliebige Anzahl an Questions anhand einer Category aus der
	 * DB auszulesen
	 * 
	 * @param	category 
	 * @return	Vector mit Questions, die der Category zugeordnet sind
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Vector<Question> findByCategory(Category cat) throws RuntimeException {
			
		//Einholen einer DB-Verbindung		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		ResultSet rs;
		Vector<Question> questions = new Vector<Question>();
		try{
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Question WHERE categoryid=" + cat.getId() + " AND Active = 1 ORDER BY questionbody";
			rs = stmt.executeQuery(sql);
			
			// Erstellung des "Question-Vectors"
			while(rs.next()){
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestionText(rs.getString("questionbody"));
				if (rs.getInt("image") == 1) {
					question.setImage(true);
				} else {
					question.setImage(false);
				}
				question.setPositionofRightAnswer(rs.getInt("correctAnswer"));
				question.setDifficulty(rs.getInt("severity"));
				question.setAnswer1Text(rs.getString("Answer_1"));
				question.setAnswer2Text(rs.getString("Answer_2"));
				question.setAnswer3Text(rs.getString("Answer_3"));
				question.setAnswer4Text(rs.getString("Answer_4"));
				if (rs.getInt("Active") == 1) {
					question.setActive(true);
				} else {
					question.setActive(false);
				}
				question.setCategoryId(rs.getInt("categoryid"));
				questions.add(question);
			}
						
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm fbk: " + e1.getMessage());				
		}
		
		db.closeConnection();
		return questions;
	}
	
	/**
	 * Methode um eine beliebige Anzahl an Questions anhand einer Category
	 * und Schwierigkeitsstufe aus der DB auszulesen
	 * 
	 * @param	category 
	 * @return	Vector mit Questions, die der Category zugeordnet sind
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Vector<Question> findByCategoryAndSeverity(Category cat, int severity) throws RuntimeException {
			
		//Einholen einer DB-Verbindung		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		ResultSet rs;
		Vector<Question> questions = new Vector<Question>();
		try{
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Question WHERE categoryid=" + cat.getId() + " AND Active=1 AND severity=" + severity + " ORDER BY questionbody";
			rs = stmt.executeQuery(sql);
			
			// Erstellung des "Question-Vectors"
			while(rs.next()){
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestionText(rs.getString("questionbody"));
				if (rs.getInt("image") == 1) {
					question.setImage(true);
				} else {
					question.setImage(false);
				}
				question.setPositionofRightAnswer(rs.getInt("correctAnswer"));
				question.setDifficulty(rs.getInt("severity"));
				question.setAnswer1Text(rs.getString("Answer_1"));
				question.setAnswer2Text(rs.getString("Answer_2"));
				question.setAnswer3Text(rs.getString("Answer_3"));
				question.setAnswer4Text(rs.getString("Answer_4"));
				if (rs.getInt("Active") == 1) {
					question.setActive(true);
				} else {
					question.setActive(false);
				}
				question.setCategoryId(rs.getInt("categoryid"));
				questions.add(question);
			}
						
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm fbk: " + e1.getMessage());				
		}
		
		db.closeConnection();
		return questions;
	}
	
	/**
	 * Methode um eine beliebige Anzahl an Questions anhand eines Quizzes aus der
	 * DB auszulesen
	 * 
	 * @param	quiz 
	 * @return	Vector mit Questions, die dem Quiz zugeordnet sind
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Vector<Question> findByQuiz(Quiz quiz) throws RuntimeException {
			
		//Einholen einer DB-Verbindung		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		ResultSet rs;
		Vector<Question> questions = new Vector<Question>();
		try{
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM `hdm-clicker`.Question WHERE id IN (SELECT questionid "
					+ "FROM `hdm-clicker`.NMTable_QQ WHERE quizid="+quiz.getId()+" AND quizversion="+quiz.getVersion()+");";
			rs = stmt.executeQuery(sql);
			
			// Erstellung des "Question-Vectors"
			while(rs.next()){
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestionText(rs.getString("questionbody"));
				if (rs.getInt("image") == 1) {
					question.setImage(true);
				} else {
					question.setImage(false);
				}
				question.setPositionofRightAnswer(rs.getInt("correctAnswer"));
				question.setDifficulty(rs.getInt("severity"));
				question.setAnswer1Text(rs.getString("Answer_1"));
				question.setAnswer2Text(rs.getString("Answer_2"));
				question.setAnswer3Text(rs.getString("Answer_3"));
				question.setAnswer4Text(rs.getString("Answer_4"));
				if (rs.getInt("Active") == 1) {
					question.setActive(true);
				} else {
					question.setActive(false);
				}
				question.setCategoryId(rs.getInt("categoryid"));
				questions.add(question);
			}
						
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm fbqz: " + e1.getMessage());				
		}
		
		db.closeConnection();
		return questions;
	}
	
	
	/**
	 * Methode um eine Question in der DB zu aktualisieren
	 * 
	 * @param	question - Objekt welches aktualisiert werden soll 			
	 * @return	Question-Objekt
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Question update(Question question) throws RuntimeException {
		int image;
		int active;
		
		if (question.isImage()) {
			image = 1;
		} else {
			image = 0;
		}
		
		if (question.isActive()) {
			active = 1;
		} else {
			active = 0;
		}
		
		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		
		// Aktualisierung der Question-Entität in der DB		
		try{
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "UPDATE Question SET questionbody='"+question.getQuestionText()+"', image='"+image+"', correctAnswer='"
			+question.getPositionofRightAnswer()+"', severity='"+question.getDifficulty()+"', Answer_1='"+question.getAnswer1Text()
			+"', Answer_2='"+ question.getAnswer2Text()+"', Answer_3='"+question.getAnswer3Text()+"', Answer_4='"+question.getAnswer4Text()
			+"', Active='"+active+"', categoryid='"+question.getCategorieId()+"' WHERE id="+question.getId()+";";
			stmt.executeUpdate(sql);
			
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - cm.update: " + e1.getMessage());
		}
		
		db.closeConnection();
		return question;
	}
	
	/**
	 * Methode um eine neue Question in die DB zu schreiben
	 * 
	 * @param	question - Objekt welcher neu hinzukommt			
	 * @return	Question-Objekt
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Question insertIntoDB(Question question) throws RuntimeException {
		int image;
		int active;
		
		if (question.isImage()) {
			image = 1;
		} else {
			image = 0;
		}
		
		if (question.isActive()) {
			active = 1;
		} else {
			active = 0;
		}
		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		ResultSet rs;
						
		try{
			// Ausführung des SQL-Querys	
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO Question (`questionbody`, `image`, `correctAnswer`, `severity`, "
					+ "`Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`, `Active`, `categoryid`) "
					+ "VALUES ('"+question.getQuestionText()+"', '"+image+"', '"+question.getPositionofRightAnswer()+"', '"+question.getDifficulty()
					+"', '"+question.getAnswer1Text()+"', '"+question.getAnswer2Text()+"', '"+question.getAnswer3Text()+"', '"+question.getAnswer4Text()
					+"', '"+active+"', '"+question.getCategorieId()+"');";
			stmt.executeUpdate(sql);
			
			// Auslesen der nach einfügen einer neuen Question in DB entstandenen "größten" ID
			sql = "SELECT MAX(ID) AS maxid FROM Question;";
			rs = stmt.executeQuery(sql);
			
			// Setzen der ID dem hier aktuellen Question-Objekt
			while(rs.next()){
				question.setId(rs.getInt("maxid"));
			}
					
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm.insert: " + e1.getMessage());
		}
		
		db.closeConnection();
		return question;
	}
	
	/**
	 * Methode um alle Categories aus der DB auszulesen
	 * 
	 * @return	Vector mit Categories
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */	
	public Vector<Question> findAllActives() throws RuntimeException {
				
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		
		Vector<Question> questions = new Vector<Question>();
		
		try{		
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM Question WHERE Active = 1 ORDER BY questionbody;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setQuestionText(rs.getString("questionbody"));
				if (rs.getInt("image") == 1) {
					question.setImage(true);
				} else {
					question.setImage(false);
				}
				question.setPositionofRightAnswer(rs.getInt("correctAnswer"));
				question.setDifficulty(rs.getInt("severity"));
				question.setAnswer1Text(rs.getString("Answer_1"));
				question.setAnswer2Text(rs.getString("Answer_2"));
				question.setAnswer3Text(rs.getString("Answer_3"));
				question.setAnswer4Text(rs.getString("Answer_4"));
				if (rs.getInt("Active") == 1) {
					question.setActive(true);
				} else {
					question.setActive(false);
				}
				question.setCategoryId(rs.getInt("categoryid"));
				questions.add(question);
			}
			
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - cm fa: " + e1.getMessage());		
		}
		
		db.closeConnection();		
		return questions;
			
	}
	
	/**
	 * Methode um eine Question aus der DB zu löschen
	 * 
	 * @param	question - Objekt welches gelöscht werden soll
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public void delete(Question question) throws RuntimeException {
		
		/* Eine Question wird nur dann gelöscht, wenn sie keine Referenz
		 * auf ein Quiz oder Result besitzt, andernfalls wird als inaktiv
		 * deklariert 
		 */
		
		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		try {
			Statement stmt = con.createStatement();
			
			// Auf Referenz in Results prüfen
			
			// Auf Referent in NNTable_QQ prüfen
			
						
			// Löschen der Category-Entität
			String sql = "DELETE FROM Question WHERE id = '"+question.getId()+"';";
			stmt.executeUpdate(sql);
			
			// Question inaktiv setzen
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm.delete: " + e1.getMessage());
		}
		db.closeConnection();
	}
	
	/**
	 * Methode um eine beliebige Anzahl an Images anhand Ihrerer ID's aus der
	 * DB auszulesen
	 * 
	 * @param	keys - Primärschlüsselattribut(e) (->DB)
	 * @return	Vector mit Image-Strings, die den Primärschlüsselattributen entsprechen
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public Vector<Blob> findByKeyImage(Vector<Integer> keys) throws RuntimeException {
		StringBuffer ids = new StringBuffer();
		
		//Erstellung des dynamischen Teils des SQL-Querys	
		if (keys.size() > 1) {
			for (int i = 0; i < keys.size()-1; i++) {
			ids.append(keys.elementAt(i));	
			ids.append(",");
			}		
		}
			
		ids.append(keys.elementAt(keys.size()-1));			
			
		//Einholen einer DB-Verbindung		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		ResultSet rs;
		Vector<Blob> images = new Vector<Blob>();
		try{
			// Ausführung des SQL-Querys
			Statement stmt = con.createStatement();
			String sql = "SELECT Image FROM `hdm-clicker`.Images WHERE id IN (" + ids.toString() + ") ORDER BY id";
			rs = stmt.executeQuery(sql);
			
			// Erstellung des "Question-Vectors"
			while(rs.next()){
				Blob image = rs.getBlob("Image");
				images.add(image);
								
			}
						
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm fbkI: " + e1.getMessage());				
		}
		
		db.closeConnection();
		return images;
	}
	
	/**
	 * Methode um ein Image aus der DB zu löschen
	 * 
	 * @param	question - Objekt dessen Image gelöscht werden soll
	 * @throws	Bei der Kommunikation mit der DB kann es zu Komplikationen kommen,
	 * 			die entstandene Exception wird an die aufrufende Methode weitergereicht
	 */
	public void deleteImage(Question question) throws RuntimeException {
		
		/* Eine Question wird nur dann gelöscht, wenn sie keine Referenz
		 * auf ein Quiz oder Result besitzt, andernfalls wird als inaktiv
		 * deklariert 
		 */
		
		
		DBConnection db = new DBConnection();
		Connection con = db.connection();
		try {
			Statement stmt = con.createStatement();
			
			// Auf Referenz in Results prüfen
			
			// Auf Referent in NNTable_QQ prüfen
			
						
			// Löschen der Category-Entität
			String sql = "DELETE FROM Images WHERE id = '"+question.getId()+"';";
			stmt.executeUpdate(sql);
			
			// Question inaktiv setzen
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - qm.deleteImage: " + e1.getMessage());
		}
		db.closeConnection();
	}
	

}