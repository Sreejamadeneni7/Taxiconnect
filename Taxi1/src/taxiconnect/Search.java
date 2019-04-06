package taxiconnect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "taxiconnect";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "sree4148";
 
        Statement st;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!");
            String pid = request.getParameter("pid");
 
            ArrayList<String> al = new ArrayList<String>();
            ArrayList<String> pid_list = new ArrayList<String>();
            String query = "select * from taxi where Firstname='" + pid + "' ";
 
            System.out.println("query " + query);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            int i =0;
            while (rs.next()) {
            
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
//					out.println(rs.getString(5)); 

                	al.add(rs.getString(i));
                	i++;
                
                
              
 
                System.out.println("al :: " + al);
              
            }
            pid_list.addAll(al);
            request.setAttribute("piList", pid_list);
            RequestDispatcher view = request.getRequestDispatcher("/searchview.jsp");
            view.forward(request, response);
            conn.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}