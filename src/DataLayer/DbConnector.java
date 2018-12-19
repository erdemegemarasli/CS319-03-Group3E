package DataLayer;

import java.sql.*;

public class DbConnector {
	//ATTRIBUTES
	protected static Connection con;
	protected static final String USERNAME = "root";
	protected static final String PASSWORD = "";
	protected static final String CONN_STRING = "jdbc:mysql://localhost/logininfo?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";

	/** 
	 * @author Ensar Kaya
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
	 * @author Ensar Kaya
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

	/** 
	 * @author Ensar Kaya
	 *This method returns a string which displays all
	 *the information in the table   
	 * @return	string str, which displays all the information in the table		
	 */
	public static String showAllUserData(){
		String str="";
		try{
			con = getConnection();
			Statement stat = con.createStatement();
			String sql = "SELECT ID, username, password,map1, map2, map3, map4, map5 FROM mytable";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next())
			{
				int v=rs.getInt("ID");
				String n=rs.getString("username");
				String p=rs.getString("password");
				String m1=rs.getString("map1");
				String m2=rs.getString("map2");
				String m3=rs.getString("map3");
				String m4=rs.getString("map4");
				String m5=rs.getString("map5");		
				str+=" ID: "+v+" Username: "+n+" Password: "+p+" Map1: "+m1+" Map2: "+m2
						+" Map3: "+m3+" Map4: "+m4+" Map5: "+m5+"\n";
			}
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();}
		return str;}
	
	/** 
	 * @author Ensar Kaya
	 * 
	 * This method inserts a user into the table
	 * @param   name the name of user
	 * @param	password the password of user
	 * @return	true if insertion successful
	 * @return 	false if insertion fails 		
	 */
	public static boolean insertUser(String name, String password){
		int i = 0;
		try{
			con = getConnection();
			PreparedStatement pStat = con.prepareStatement("INSERT INTO mytable"+" VALUES(?,?,?,?,?,?,?,?)");
			pStat.setString(1,name);
			pStat.setString(2,password);
			pStat.setString(3,"");
			pStat.setString(4,"");
			pStat.setInt(5,0);
			pStat.setString(6, "");
			pStat.setString(7, "");
			pStat.setString(8,"");
			i = pStat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();}
		if(i>=1)
			return true;
		return false;}
	
	/** 
	 * @author Ensar Kaya
	 * This method uploads a map into the table
	 * @param   username the username of user
	 * @param	password the password of user
	 * @param  	map the map is going to upload
	 * @return	true if upload successful
	 * @return 	false if upload fails 		
	 */
	public static boolean uploadMap(String username,String password,String map){
		boolean rs2=false;
		int x=verifyUser(username,password);
		try{
			if(0<x)
			{
				con = getConnection();
				Statement stat= con.createStatement();
				String sql = "SELECT username, password, map1, map2 FROM mytable";
				ResultSet rs=stat.executeQuery(sql);
				while(rs.next()){
					String n=rs.getString("username");
					String p=rs.getString("password");
					String m1=rs.getString("map1");
					String m2=rs.getString("map2");
					Statement stat2=con.createStatement();
					if(n.equals(username)&&p.equals(password)&&m1.equals("")){
						String sql2="UPDATE mytable SET map1 = '" + map +"' WHERE username = '" +username+"'";
						rs2 = stat2.execute(sql2);
						return true;
					}
					else if(n.equals(username)&&p.equals(password)&&m2.equals("")){
						String sql2="UPDATE mytable SET map2 = '" + map +"' WHERE username = '" +username+"'";
						rs2 = stat2.execute(sql2);
						return true;
					}
					else if(n.equals(username)&&p.equals(password)&&!m1.equals("")&&!m2.equals("")){
						System.out.println("You're out of quota, please delete a map or buy quota!");
						return false;
					}
				}
				rs.close();		
			}
			else{
				System.out.println("Invalid username or password");
				return false;
			}
		}
		catch(SQLException e){
			e.printStackTrace();}
		if(rs2)
			return true;
		return false;	
	}
	
	/** 
	 * @author Ensar Kaya
	 *This method returns a string which displays all
	 *the uploaded maps in the table   
	 * @return	string str, which displays all the uploaded maps in the table		
	 */
	public static String showAllUploadedMaps(){
		String ret="";
		try{
			con = getConnection();
			Statement stat = con.createStatement();
			String sql = "SELECT map1, map2 FROM mytable";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next())
			{
				String m1=rs.getString("map1");
				String m2=rs.getString("map2");	
				ret+=" Map1: "+m1+" Map2: "+m2+"\n";
			}
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();}
		return ret;}
	
	public static boolean deleteUser(String name, String password){
		int i=0;
		String table="mytable";
		try{
			con = getConnection();
			PreparedStatement pStat = con.prepareStatement("DELETE FROM "+ table+" WHERE username = '"+ name+"'");

			i = pStat.executeUpdate();}
		catch(SQLException e){
			e.printStackTrace();}
		if(i>=1)
			return true;
		return false;}
	
}