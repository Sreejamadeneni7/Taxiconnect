package taxiconnect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class LoginServlet
 */


@WebServlet(urlPatterns= {"/loginServlet"})
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Firstname=request.getParameter("Firstname");
		String Password=request.getParameter("Password");
		if(LoginDao.validate(Firstname, Password)){
			//out.print("you are successfully logged in!");
			request.getSession().setAttribute("login", "true");
			request.getSession().setAttribute("Firstname", Firstname);
			request.getSession().setAttribute("Password", Password);
			response.sendRedirect("profile.html");
			
		}else{
			out.print("<p>Sorry, Firstname or password incorrect</p>");
			request.getRequestDispatcher("taxilogin.html").include(request, response);
		}
		out.close();
	}

}