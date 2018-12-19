package DataLayer;

import java.sql.*;

public class DbConnector {
	//ATTRIBUTES
	protected static Connection con;
	protected static final String USERNAME = "root";
	protected static final String PASSWORD = "";
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
	
	/** 
	 *This method search username, password parameters in mytable
	 *return -1 if it's not founded 
	 *return an positive integer which is the index number 
	 * @param     
	 * @return	It returns int ret which is an positive integer when user exist in the table or -1 if its not exist		
	 */
	public static int verifyUser(String name, String password){
		int ret=-1;
		String n,p;
		try{
			con = getConnection();
			Statement stat = con.createStatement();
			String sql = "SELECT username, password,ID FROM mytable";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next())
			{
				n=rs.getString("username");
				p=rs.getString("password");
				if(n.equals(name)&&p.equals(password))
					ret= rs.getInt("ID");//index of founded row
			}
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();}		
		return ret;}

	
}