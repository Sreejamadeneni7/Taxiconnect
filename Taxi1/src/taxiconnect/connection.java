package taxiconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class connection {
	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connecting to the database");
			Connection conn=DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/taxiconnect","root","sree4148"); 
			Statement stmt=conn.createStatement();  
	        ResultSet rs=stmt.executeQuery("select * from taxi");  
	        while(rs.next())  
	        System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7));  
			conn.close();  
			}catch(Exception e){ System.out.println(e);}
	}
}
