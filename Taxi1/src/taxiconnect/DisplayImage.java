/*
 * package taxiconnect;
 * 
 * 
 * import java.io.BufferedInputStream; import java.io.BufferedOutputStream;
 * import java.io.FileInputStream; import java.io.IOException;
 * 
 * import javax.servlet.ServletOutputStream; import
 * javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse; public class DisplayImage
 * extends HttpServlet {
 * 
 * 
 * private String filePath; public void init() { // Get the file location where
 * it would be stored. // filePath =
 * getServletContext().getInitParameter("file-upload");
 * 
 * //System.out.println(filePath); }
 * 
 * public void doGet(HttpServletRequest request,HttpServletResponse response)
 * throws IOException { response.setContentType("image/jpeg");
 * ServletOutputStream out; out = response.getOutputStream(); FileInputStream
 * fin = new FileInputStream("c:\\test\\java.jpg");
 * 
 * BufferedInputStream bin = new BufferedInputStream(fin); BufferedOutputStream
 * bout = new BufferedOutputStream(out); int ch =0; ; while((ch=bin.read())!=-1)
 * { bout.write(ch); }
 * 
 * bin.close(); fin.close(); bout.close(); out.close(); } }
 */