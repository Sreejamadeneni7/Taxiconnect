package taxiconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class RegiserDao {

	public static int save(String Firstname,String Lastname,String Email,String Password,String AGE,String Gender,String CarModel){
		int status=0;
		try{
			
			System.out.println("just entered the save method ...");
			
			
			
			
			
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiconnect","root","sree4148");
			PreparedStatement ps=conn.prepareStatement("INSERT INTO taxi(Firstname,Lastname, Email, Password,AGE,Gender,CarModel) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, Firstname);
			ps.setString(2, Lastname);
			ps.setString(3, Email);
			ps.setString(4, Password);
			ps.setString(5, AGE);
			ps.setString(6, Gender);
			ps.setString(7, CarModel);			
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}		
		return status;
	}
}
