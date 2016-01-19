import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Susmitha_NextBeeQ4P1b {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";
	
	static final String username = "root";
	static final String password = "";
	
	public static void main(String[] args){
		LinkedHashMap<Integer,Integer> ageCountMap = fetchDataFromDB(); //contains age,count
		LinkedHashMap<Integer,Integer> newHash = new LinkedHashMap<Integer,Integer>(); //will contain startingAge, countUntil5Years
		
		//max_age_value is the first value in the linkedhashMap as the order was preserved while insertion. It is the maximum band value.
		int max_age_value = ageCountMap.keySet().iterator().next();
		
		//commented just to avoid redundancy both for loops work without any errors.
		/*for(int i=1; i <= max_age_value; i++){
			for(int j=i ; j< i+5; j++){
				if(ageCountMap.get(j) != null){
					if(newHash.get(i) == null)
						newHash.put(i, 0);
					
					System.out.println("i: " + i + " j: " + j + " value: " + (newHash.get(i) + ageCountMap.get(j)));
					newHash.put(i, newHash.get(i)+ageCountMap.get(j));
				}
			}
		}*/
		
		//Used to calculate the sum of count of ages ranging for every 5 years starting from 1.
		for(int i=1; i <= max_age_value; i++){
			int count =0;
			for(int j=i ; j< i+5; j++){
				if(ageCountMap.get(j) != null){
					count += ageCountMap.get(j);
					newHash.put(i, count);
				}
			}

		}
		
		//Used to find the maximum value of the result set and the year band.
		int max = 0, age =0;
		for(Map.Entry<Integer, Integer> entry: newHash.entrySet()) {
			int value = entry.getValue();
			if(max < value) {
				max = value;
				age = entry.getKey();
			}
			
		}
		//output
		System.out.println("band range: " + age + "-"+ (age +5) + " with number of profiles: "+ max);
		
	}
	
	public static LinkedHashMap<Integer,Integer> fetchDataFromDB(){
		Connection conn =  null;
		Statement stmt = null;
		LinkedHashMap<Integer,Integer> age_Count = new LinkedHashMap<Integer,Integer>();
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,username,password);
			stmt = conn.createStatement();
			
			//query to fetch the age and its number of occurrences in the dataset in the descending order age.
			String problem2 = "select count(1) as count, age_as_integer from member group by age_as_integer order by age_as_integer desc";
			
			ResultSet rs = stmt.executeQuery(problem2);
			
			//iterating through the result set and adding values to LinkedHashMap to preserve the insertion order.
			while(rs.next()){
				age_Count.put(rs.getInt("age_as_integer"), rs.getInt("count"));
				System.out.println("count: "+ rs.getInt("count")+ " age: "+ rs.getInt("age_as_integer"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return age_Count;	
	}
}
