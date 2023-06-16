package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteDataToDatabase {

	public static void main(String[] args) throws SQLException {
		
		//Step1-Register Driver
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//Step2-Connection to databse                                        //database name         
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/weekendbatch","root","root");
		                                                                                           //username  password
				//step3-Create sql statement
				Statement stat=con.createStatement();
				
				String query="insert into student(frist_name,last_name)values('Mahima','Rao')";
				int result=stat.executeUpdate(query);
				
				if(result==1)  //reult=1 means value is +ve and tble is updated
				{
					System.out.println("Data Updated");
				}
				else
				{
					System.out.println("Data not Updated");
				}
				con.close();

	}

}
