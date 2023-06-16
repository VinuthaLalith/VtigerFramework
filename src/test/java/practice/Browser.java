package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Browser {

	public static void main(String[] args) throws Throwable {
		//Step1-Register Driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2-Connection to databse                                        //database name         
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/weekendbatch","root","root");
                                                                                           //username  password
		//step3-Create sql statement
		Statement stat=con.createStatement();
		String query="select * from student";
		                          //table name
		//step4-Execute Query
		ResultSet result = stat.executeQuery(query);
		while(result.next()) {
			//System.out.println(result.getInt(1)+"\t"+result.getString(3));
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));	
		}
		
		//Step5-Close database connection
		
		con.close();
		
	}

}
