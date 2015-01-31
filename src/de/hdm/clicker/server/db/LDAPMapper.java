package de.hdm.clicker.server.db;


import java.sql.*;
import java.util.Vector;



import de.hdm.clicker.shared.bo.*;

/**
 * Mapper-Klasse, die <code>Lecturer</code>-Objekte auf eine relationale
 * Datenbank abbildet. Hierzu wird eine Reihe von Methoden zur Verfügung
 * gestellt, mit deren Hilfe z.B. Objekte gesucht, erzeugt, modifiziert und
 * gelöscht werden können. Das Mapping ist bidirektional. D.h., Objekte können
 * in DB-Strukturen und DB-Strukturen in Objekte umgewandelt werden.
 * 
 * @see QuizMapper
 * @see CategoryMapper
 * @see QuestionMapper
 * @see ResultsMapper
 * 
 * @author Zimmermann, Roth, Zanella
 * @version 1.0
 */
public class LDAPMapper {
	
	/**
	 * Die Klasse LecturerMapper wird nur einmal instantiiert. Man spricht hierbei
	 * von einem sogenannten <b>Singleton</b>.
	 * <p>
	 * Diese Variable ist durch den Bezeichner <code>static</code> nur einmal für
	 * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	 * einzige Instanz dieser Klasse.
	 */
	private static LDAPMapper ldapmapper = null;
	
	/**
	 * Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
	 * Instanzen dieser Klasse zu erzeugen.
	 * 
	 */
	protected LDAPMapper(){
		
	}
	
	/**
	 * Diese statische Methode kann aufgrufen werden durch
	 * <code>LecturerMapper.lecturerMapper()</code>. Sie stellt die
	 * Singleton-Eigenschaft sicher, indem Sie dafür sorgt, dass nur eine einzige
	 * Instanz von <code>LecturerMapper</code> existiert.
	 * <p>
	 * 
	 * <b>Fazit:</b> LecturerMapper sollte nicht mittels <code>new</code>
	 * instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 * 
	 * @return DAS <code>LecturerMapper</code>-Objekt.
	 */
	public static LDAPMapper ldapMapper() {
	    if (ldapmapper == null) {
	      ldapmapper = new LDAPMapper();
	    }

	    return ldapmapper;
	   }
	
	
	
	public User findUserbyLogin(String user, String password)throws RuntimeException{
		
		//Datenbankverbindung aufbauen
		DBConnection db = new DBConnection();
		Connection connection = db.connection();
		ResultSet resultset;
		User predefineduser = null;
		try{
			// Ausführung des SQL-Querys
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM LDAP WHERE Username = '"+user+"' and Password = '"+password+"'";
			resultset = stmt.executeQuery(sql);
			
			
			while(resultset.next()){
			//	if(resultset.getString("Username").matches(".*\\d+*"))
				
				predefineduser= new User();
				
				predefineduser.setId(resultset.getInt("idLDAP"));
				predefineduser.setUsername(resultset.getString("Username"));
				predefineduser.setPassword(resultset.getString("Password"));
				predefineduser.setFirstname(resultset.getString("Firstname"));
				predefineduser.setLastname(resultset.getString("Lastname")); 
				
			}
			db.closeConnection();
			return predefineduser;
		}
		catch (SQLException e1) {
			throw new RuntimeException("Datenbankbankproblem - dm fbk: " + e1.getMessage());				
		}	
		
		
	}
	

}