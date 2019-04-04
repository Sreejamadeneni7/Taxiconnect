package taxiconnect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns= {"/Register"})
public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("just entered post call....");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String Firstname=request.getParameter("Firstname");
		String Lastname=request.getParameter("Lastname");
		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		String AGE=request.getParameter("AGE");
		String Gender=request.getParameter("Gender");
		String CarModel=request.getParameter("Carmodel");
		int status=RegiserDao.save(Firstname,Lastname, Email,Password, AGE,Gender,CarModel);
		if(status>0){
			out.print("<p>You are successfully registered!</p>");
			request.getRequestDispatcher("taxilogin.html").include(request, response);	
		}
		out.close();
	}
}
