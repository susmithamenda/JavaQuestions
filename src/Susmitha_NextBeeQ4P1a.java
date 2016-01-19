
import java.sql.*;

public class Susmitha_NextBeeQ4P1a {
	
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";
	
	static final String username = "root";
	static final String password = "";

	public static void main(String[] args){
		solution1();
	}
	
	public static void solution1(){
		Connection conn = null;
		Statement stmt = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,username,password);
		
		stmt = conn.createStatement();
		
		//select query that returns age and the number of occurrences
		String problem1 = "select age_as_integer, count(1) as total from member group by age_as_integer order by total desc limit 1";
		
		ResultSet rs = stmt.executeQuery(problem1);
		
		while(rs.next()){
			System.out.println("Age that has the most number of members through query1: " + rs.getInt("age_as_integer"));
		}

		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/*public static void solution2(){
		Connection conn = null;
		Statement stmt = null;
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,username,password);
		
		stmt = conn.createStatement();
		String problem1 = "select age_as_integer from (select age_as_integer, count(1) as total from member group by age_as_integer order by total desc limit 1) as result";
		
		ResultSet rs = stmt.executeQuery(problem1);
		
		while(rs.next()){
			System.out.println("Age that has the most number of members: through query2: " + rs.getInt("age_as_integer"));
		}

		
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/
}
