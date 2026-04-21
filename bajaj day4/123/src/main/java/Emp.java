import java.sql.*;
import java.util.ArrayList;

public class Emp {

	public static void main( String args[] ) { 
		String url = "jdbc:mysql://localhost:3306/hospital_jdbc ";
	    String username = "root";
	    String password = "manager";

	    try {
	        // 1. Load Driver (optional in newer versions)
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 2. Create Connection
	        Connection con = DriverManager.getConnection(url, username, password);

	        // 3. Create Statement
	        Statement stmt = con.createStatement();

	       

	        // 5. Execute SELECT
	        String selectQuery = "SELECT * FROM employee";
	        ResultSet rs = stmt.executeQuery(selectQuery);
	        ArrayList<Double> list = new ArrayList<>();
	        // 6. Process Result
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            double salary = rs.getDouble("salary");

	            System.out.println(id + " " + name + " " + salary);
	            list.add( salary );
	        }
	        
	        System.out.println(list);
	        double sum =  list.stream().reduce( (double) 0 , ( a , b )-> a + b );
	        System.out.println(" totoal salary is " +sum);
	        // 7. Close Connection
	        
	      
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    
	   
	}
}
