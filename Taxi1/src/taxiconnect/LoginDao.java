package taxiconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginDao {

	public static boolean validate(String Firstname,String Password){
		boolean status=false;
		try{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiconnect","root","sree4148");
			PreparedStatement ps=conn.prepareStatement("select * from taxi where Firstname=? and Password=?");
			ps.setString(1,Firstname);
			ps.setString(2,Password);
			ResultSet rs=ps.executeQuery();
		
			
			//System.out.println(rs.getArray("Firstname"));    
			if(rs.next()){
				status=true;
			}
			
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}