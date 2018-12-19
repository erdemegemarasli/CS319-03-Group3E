package DataLayer;

import java.sql.*;

public class DbConnector {
	//ATTRIBUTES
	protected static Connection con;
	//public static int id=1;
	protected static final String USERNAME = "root";
	protected static final String PASSWORD = "Ensarben1..4.j83796";
	protected static final String CONN_STRING = "jdbc:mysql://localhost/logininfo?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";

	/** 
	 * This method creates a MySql connection by using
	 * Username,Password and URL of the my database
	 * @param     
	 * @return	It returns Connection con
	 */
	public static Connection getConnection(){
		Connection con = null;
		try{
			con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		}
		catch(SQLException e){
			System.err.println(e);
		}
		return con;
	}
	
	
}